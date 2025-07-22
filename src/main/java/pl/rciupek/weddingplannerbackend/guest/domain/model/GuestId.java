package pl.rciupek.weddingplannerbackend.guest.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record GuestId(UUID id) {

  public GuestId {
    Assert.notNull(id, "id must not be null");
  }

  public GuestId() {
    this(UUID.randomUUID());
  }
}
