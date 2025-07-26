package pl.rciupek.weddingplannerbackend.auth.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.rciupek.weddingplannerbackend.auth.application.model.AuthenticationResponseDto;
import pl.rciupek.weddingplannerbackend.auth.application.model.RegisterCommand;
import pl.rciupek.weddingplannerbackend.common.annotation.UseCase;
import pl.rciupek.weddingplannerbackend.common.jwt.JwtService;
import pl.rciupek.weddingplannerbackend.user.domain.model.Role;
import pl.rciupek.weddingplannerbackend.user.domain.model.User;
import pl.rciupek.weddingplannerbackend.user.domain.repository.UserRepository;

@UseCase
@RequiredArgsConstructor
public class RegisterUseCase {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final JwtService jwtService;

  public AuthenticationResponseDto execute(final RegisterCommand command) {
    final User user = new User(command.username(), passwordEncoder.encode(command.password()), Role.USER);
    final User savedUser = userRepository.save(user);

    final String token = jwtService.generateToken(savedUser);
    return AuthenticationResponseDto.builder()
        .token(token)
        .build();
  }
}
