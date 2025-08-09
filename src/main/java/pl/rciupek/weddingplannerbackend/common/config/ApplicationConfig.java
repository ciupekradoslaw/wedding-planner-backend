package pl.rciupek.weddingplannerbackend.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.repository.jpa.UserJpaRepository;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserJpaRepository userJpaRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> userJpaRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }

  @Bean
  public AuthenticationProvider daoAuthenticationProvider() {
    final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());

    return authenticationProvider;
  }

  @Bean
  public AuthenticationManager authManager(final List<AuthenticationProvider> providers) {
    return new ProviderManager(providers);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
