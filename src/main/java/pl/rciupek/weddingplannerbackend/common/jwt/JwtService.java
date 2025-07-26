package pl.rciupek.weddingplannerbackend.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.rciupek.weddingplannerbackend.user.domain.model.User;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

  @Value("${wedding-planner.security.jwt.secret-key}")
  private String secretKey;

  public String extractUsername(final String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver) {
    final Claims claims = extractClaims(token);
    return claimsResolver.apply(claims);
  }

  public String generateToken(final User user) {
    return generateToken(new HashMap<>(), user);
  }

  public String generateToken(final Map<String, Object> extraClaims, final User user) {
    return Jwts.builder()
        .claims(extraClaims)
        .subject(user.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 1000 * 30 * 60))
        .signWith(getSignKey(), Jwts.SIG.HS256)
        .compact();
  }

  public boolean isTokenValid(final String token, final UserDetails userDetails) {
    final String username = extractUsername(token);
    return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(final String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(final String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private Claims extractClaims(final String token) {
    return Jwts.parser()
        .verifyWith(getSignKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }

  private SecretKey getSignKey() {
    final byte[] keyBytes = Base64.getDecoder().decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
