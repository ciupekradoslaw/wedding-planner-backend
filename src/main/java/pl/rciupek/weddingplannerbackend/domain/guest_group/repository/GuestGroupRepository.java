package pl.rciupek.weddingplannerbackend.domain.guest_group.repository;

import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.infrastructure.persistence.entity.GuestGroupEntity;

public interface GuestGroupRepository {
  GuestGroupEntity save(final GuestGroup guestGroup);
  boolean existsByName(final String name);
}
