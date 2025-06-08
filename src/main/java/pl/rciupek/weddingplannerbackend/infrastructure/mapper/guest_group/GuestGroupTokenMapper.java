package pl.rciupek.weddingplannerbackend.infrastructure.mapper.guest_group;

import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroupToken;
import pl.rciupek.weddingplannerbackend.infrastructure.mapper.IdMapper;

import java.util.UUID;

public class GuestGroupTokenMapper implements IdMapper<GuestGroupToken, UUID> {

  @Override
  public UUID toEntityId(final GuestGroupToken value) {
    return value != null ? value.token() : null;
  }

  @Override
  public GuestGroupToken toDomainId(final UUID value) {
    return value != null ? new GuestGroupToken(value) : null;
  }
}
