package pl.rciupek.weddingplannerbackend.guest.infrastructure.mapper;

import pl.rciupek.weddingplannerbackend.common.mapper.IdMapper;
import pl.rciupek.weddingplannerbackend.guest.domain.model.GuestId;

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
