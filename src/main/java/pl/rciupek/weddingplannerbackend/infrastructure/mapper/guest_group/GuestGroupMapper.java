package pl.rciupek.weddingplannerbackend.infrastructure.mapper.guest_group;

import org.mapstruct.Mapper;
import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.infrastructure.mapper.guest.GuestIdMapper;
import pl.rciupek.weddingplannerbackend.infrastructure.persistence.entity.GuestGroupEntity;

@Mapper(uses = {GuestGroupIdMapper.class, GuestGroupTokenMapper.class, GuestIdMapper.class})
public interface GuestGroupMapper {

  GuestGroupEntity toGuestGroupEntity(final GuestGroup guestGroup);

  GuestGroup toGuestGroup(final GuestGroupEntity guestGroupEntity);
}
