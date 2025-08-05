package pl.rciupek.weddingplannerbackend.auth.infrastructure.exposition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rciupek.weddingplannerbackend.auth.application.model.*;
import pl.rciupek.weddingplannerbackend.auth.application.service.LoginUseCase;
import pl.rciupek.weddingplannerbackend.auth.application.service.RegisterUseCase;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final LoginUseCase loginUseCase;
  private final RegisterUseCase registerUseCase;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponseDto> register(@RequestBody final RegisterRequestDto request) {
    return ResponseEntity.ok(registerUseCase.execute(new RegisterCommand(request.username(), request.password())));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponseDto> login(@RequestBody final LoginRequestDto request) {
    return ResponseEntity.ok(loginUseCase.execute(new LoginCommand(request.username(), request.password())));
  }
}
