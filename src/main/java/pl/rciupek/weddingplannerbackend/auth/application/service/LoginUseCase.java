package pl.rciupek.weddingplannerbackend.auth.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import pl.rciupek.weddingplannerbackend.auth.application.model.AuthenticationResponseDto;
import pl.rciupek.weddingplannerbackend.auth.application.model.LoginCommand;
import pl.rciupek.weddingplannerbackend.common.annotation.UseCase;
import pl.rciupek.weddingplannerbackend.common.jwt.JwtService;
import pl.rciupek.weddingplannerbackend.user.domain.model.User;
import pl.rciupek.weddingplannerbackend.user.domain.repository.UserRepository;

@UseCase
@RequiredArgsConstructor
public class LoginUseCase {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final JwtService jwtService;

  public AuthenticationResponseDto execute(final LoginCommand command) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            command.username(),
            command.password()
        ));

    final User user = userRepository.findByUsername(command.username());
    final String token = jwtService.generateToken(user);

    return new AuthenticationResponseDto(token);
  }
}
