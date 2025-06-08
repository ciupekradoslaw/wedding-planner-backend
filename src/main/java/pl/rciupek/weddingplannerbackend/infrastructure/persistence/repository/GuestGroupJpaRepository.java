package pl.rciupek.weddingplannerbackend.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rciupek.weddingplannerbackend.infrastructure.persistence.entity.GuestGroupEntity;

import java.util.UUID;

@Repository
public interface GuestGroupJpaRepository extends JpaRepository<GuestGroupEntity, UUID> {

  boolean existsByName(String name);
}
