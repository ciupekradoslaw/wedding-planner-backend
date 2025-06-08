package pl.rciupek.weddingplannerbackend.infrastructure.mapper.guest_group;

import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroupId;
import pl.rciupek.weddingplannerbackend.infrastructure.mapper.IdMapper;

import java.util.UUID;

public class GuestGroupIdMapper implements IdMapper<GuestGroupId, UUID> {

  @Override
  public UUID toEntityId(final GuestGroupId value) {
    return value != null ? value.id() : null;
  }

  @Override
  public GuestGroupId toDomainId(final UUID value) {
    return value != null ? new GuestGroupId(value) : null;
  }
}
