package pl.rciupek.weddingplannerbackend.common.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AdminAuthenticationProvider implements AuthenticationProvider {

  private static final char[] USERNAME =
      "$2a$10$iswl67MPVaUMwf5Q0f2PAe0N5Ip5Y4f1GME64Vlpf00xz.kLawnCy".toCharArray();
  private static final char[] PASSWORD =
      "$2a$10$zFI7i22s5a669dsyqldVPukUSBJC9autZ4dW5tbgPmjvDe6FSDI2.".toCharArray();

  private final PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
    final String username = authentication.getName();
    final String password = authentication.getCredentials().toString();

    if (areSame(username, USERNAME) && areSame(password, PASSWORD)) {
      return authenticateAgainstThirdPartyAndGetAuthentication(username, password);
    }
    return null;
  }

  private static UsernamePasswordAuthenticationToken authenticateAgainstThirdPartyAndGetAuthentication(
      final String name,
      final String password
  ) {
    final List<GrantedAuthority> grantedAuths = new ArrayList<>();
    grantedAuths.add(new SimpleGrantedAuthority("ADMIN"));
    final UserDetails principal = new User(name, password, grantedAuths);
    return new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.equals(authentication);
  }

  private boolean areSame(final String raw, final char[] encoded) {
    return passwordEncoder.matches(raw, String.valueOf(encoded));
  }
}
