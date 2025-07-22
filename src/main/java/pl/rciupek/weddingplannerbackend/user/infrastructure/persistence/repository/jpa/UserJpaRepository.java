package pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.entity.UserEntity;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
}
