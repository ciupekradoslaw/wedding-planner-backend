package pl.rciupek.weddingplannerbackend.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.repository.jpa.UserJpaRepository;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserJpaRepository userJpaRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> userJpaRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
