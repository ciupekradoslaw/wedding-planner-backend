package pl.rciupek.weddingplannerbackend.guest.infrastructure.mapper;

import org.mapstruct.Mapper;
import pl.rciupek.weddingplannerbackend.guest.domain.model.Guest;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.entity.GuestEntity;

@Mapper(componentModel = "spring", uses = GuestIdMapper.class)
public interface GuestEntityMapper {
  Guest toDomain(final GuestEntity guestEntity);
}
