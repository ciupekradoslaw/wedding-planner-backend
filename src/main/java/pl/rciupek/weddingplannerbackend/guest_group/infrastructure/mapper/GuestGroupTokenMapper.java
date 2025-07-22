package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.mapper;

import pl.rciupek.weddingplannerbackend.common.mapper.IdMapper;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroupToken;

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
