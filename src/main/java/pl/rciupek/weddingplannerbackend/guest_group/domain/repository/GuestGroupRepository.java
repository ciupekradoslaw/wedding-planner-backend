package pl.rciupek.weddingplannerbackend.guest_group.domain.repository;

import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroup;

public interface GuestGroupRepository {
  GuestGroup save(final GuestGroup guestGroup);
  boolean existsByName(final String name);
}
