package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.mapper.GuestIdMapper;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.guest_group.infrastructure.persistence.entity.GuestGroupEntity;

@Mapper(uses = {GuestGroupIdMapper.class, GuestGroupTokenMapper.class, GuestIdMapper.class})
public interface GuestGroupMapper {
  GuestGroupMapper INSTANCE = Mappers.getMapper(GuestGroupMapper.class);

  GuestGroupEntity toGuestGroupEntity(final GuestGroup guestGroup);
  GuestGroup toGuestGroup(final GuestGroupEntity guestGroupEntity);
}
