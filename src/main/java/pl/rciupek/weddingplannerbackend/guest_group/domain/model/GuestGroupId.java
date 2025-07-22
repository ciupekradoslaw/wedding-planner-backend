package pl.rciupek.weddingplannerbackend.guest_group.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record GuestGroupId(UUID id) {

  public GuestGroupId {
    Assert.notNull(id, "id must not be null");
  }

  public GuestGroupId() {
    this(UUID.randomUUID());
  }
}
