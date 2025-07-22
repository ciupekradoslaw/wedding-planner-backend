package pl.rciupek.weddingplannerbackend.guest_group.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record GuestGroupToken(UUID token) {

  public GuestGroupToken {
    Assert.notNull(token, "token must not be null");
  }

  public GuestGroupToken() {
    this(UUID.randomUUID());
  }
}
