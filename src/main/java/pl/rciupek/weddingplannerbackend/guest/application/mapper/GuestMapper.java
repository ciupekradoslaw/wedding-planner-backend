package pl.rciupek.weddingplannerbackend.guest.application.mapper;

import org.mapstruct.Mapper;
import pl.rciupek.weddingplannerbackend.guest.application.model.GuestResponseDto;
import pl.rciupek.weddingplannerbackend.guest.domain.model.Guest;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.mapper.GuestIdMapper;

@Mapper(componentModel = "spring", uses = {GuestIdMapper.class})
public interface GuestMapper {

  GuestResponseDto toResponseDto(Guest guest);
}
