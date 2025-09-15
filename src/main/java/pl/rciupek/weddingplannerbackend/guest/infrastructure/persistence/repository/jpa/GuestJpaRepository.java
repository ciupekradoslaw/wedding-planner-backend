package pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.entity.GuestEntity;

import java.util.UUID;

@Repository
public interface GuestJpaRepository extends JpaRepository<GuestEntity, UUID> {
}
