package pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.rciupek.weddingplannerbackend.user.domain.model.User;
import pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.entity.UserEntity;

@Mapper(uses = {UserIdMapper.class})
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserEntity toEntity(final User user);
  User toDomain(final UserEntity entity);
}
