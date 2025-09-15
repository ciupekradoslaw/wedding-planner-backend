package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.mapper;

import org.mapstruct.Mapper;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.mapper.GuestIdMapper;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.guest_group.infrastructure.persistence.entity.GuestGroupEntity;

@Mapper(componentModel = "spring", uses = {GuestGroupIdMapper.class, GuestGroupTokenMapper.class, GuestIdMapper.class})
public interface GuestGroupMapper {
  GuestGroupEntity toEntity(final GuestGroup guestGroup);
  GuestGroup toDomain(final GuestGroupEntity guestGroupEntity);
}
