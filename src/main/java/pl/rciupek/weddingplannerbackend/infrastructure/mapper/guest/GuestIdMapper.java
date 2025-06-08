package pl.rciupek.weddingplannerbackend.infrastructure.mapper.guest;

import pl.rciupek.weddingplannerbackend.domain.guest.model.GuestId;
import pl.rciupek.weddingplannerbackend.infrastructure.mapper.IdMapper;

import java.util.UUID;

public class GuestIdMapper implements IdMapper<GuestId, UUID> {

  @Override
  public UUID toEntityId(final GuestId value) {
    return value != null ? value.id() : null;
  }

  @Override
  public GuestId toDomainId(final UUID value) {
    return value != null ? new GuestId(value) : null;
  }
}
