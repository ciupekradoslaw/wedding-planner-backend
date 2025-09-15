package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.mapper;

import org.mapstruct.Mapper;
import pl.rciupek.weddingplannerbackend.common.mapper.IdMapper;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroupId;

import java.util.UUID;

@Mapper(componentModel = "spring")
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
