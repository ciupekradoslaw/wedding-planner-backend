package pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.mapper;

import pl.rciupek.weddingplannerbackend.common.mapper.IdMapper;
import pl.rciupek.weddingplannerbackend.user.domain.model.UserId;

import java.util.UUID;

public class UserIdMapper implements IdMapper<UserId, UUID> {

  @Override
  public UUID toEntityId(final UserId value) {
    return value != null ? value.id() : null;
  }

  @Override
  public UserId toDomainId(final UUID value) {
    return value != null ? new UserId(value) : null;
  }
}
