package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.guest_group.domain.repository.GuestGroupRepository;
import pl.rciupek.weddingplannerbackend.guest_group.infrastructure.mapper.GuestGroupMapper;
import pl.rciupek.weddingplannerbackend.guest_group.infrastructure.persistence.entity.GuestGroupEntity;
import pl.rciupek.weddingplannerbackend.guest_group.infrastructure.persistence.repository.jpa.GuestGroupJpaRepository;

@Repository
@RequiredArgsConstructor
public class GuestGroupRepositoryImpl implements GuestGroupRepository {

  private final GuestGroupJpaRepository jpaRepository;
  private final GuestGroupMapper guestGroupMapper;

  @Override
  public GuestGroup save(final GuestGroup guestGroup) {
    final GuestGroupEntity entity = jpaRepository.save(guestGroupMapper.toEntity(guestGroup));
    return guestGroupMapper.toDomain(entity);
  }

  @Override
  public boolean existsByName(final String name) {
    return jpaRepository.existsByName(name);
  }
}
