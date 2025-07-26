package pl.rciupek.weddingplannerbackend.user.domain.repository;

import pl.rciupek.weddingplannerbackend.user.domain.model.User;

public interface UserRepository {
  User save(final User user);
  User findByUsername(final String username);
}
