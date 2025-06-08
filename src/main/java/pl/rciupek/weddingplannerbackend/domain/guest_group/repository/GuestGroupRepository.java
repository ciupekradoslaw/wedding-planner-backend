package pl.rciupek.weddingplannerbackend.domain.guest_group.repository;

import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroup;

public interface GuestGroupRepository {
  void save(final GuestGroup guestGroup);
  boolean existsByName(final String name);
}
