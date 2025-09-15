package pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import pl.rciupek.weddingplannerbackend.user.domain.model.User;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.entity.UserEntity;

@Mapper( componentModel = "spring", uses = {UserIdMapper.class})
public interface UserMapper {
  UserEntity toEntity(final User user);
  User toDomain(final UserEntity entity);
}
