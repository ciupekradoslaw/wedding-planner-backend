package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.mapper;

import pl.rciupek.weddingplannerbackend.common.mapper.IdMapper;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroupId;

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
