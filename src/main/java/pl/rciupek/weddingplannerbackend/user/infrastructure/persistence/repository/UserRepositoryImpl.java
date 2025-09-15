package pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.rciupek.weddingplannerbackend.user.domain.model.User;
import pl.rciupek.weddingplannerbackend.user.domain.repository.UserRepository;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.entity.UserEntity;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.mapper.UserMapper;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.repository.jpa.UserJpaRepository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserMapper userMapper;

  @Override
  @Transactional
  public User save(final User user) {
    final UserEntity entity = userJpaRepository.save(userMapper.toEntity(user));
    return userMapper.toDomain(entity);
  }

  @Override
  @Transactional
  public User findByUsername(final String username) {
    final UserEntity entity = userJpaRepository.findByUsername(username)
        .orElseThrow();

    return userMapper.toDomain(entity);
  }
}
