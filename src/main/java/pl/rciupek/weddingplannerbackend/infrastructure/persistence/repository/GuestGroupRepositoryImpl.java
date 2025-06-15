package pl.rciupek.weddingplannerbackend.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.domain.guest_group.repository.GuestGroupRepository;
import pl.rciupek.weddingplannerbackend.infrastructure.mapper.guest_group.GuestGroupMapper;
import pl.rciupek.weddingplannerbackend.infrastructure.persistence.entity.GuestGroupEntity;

@Repository
@RequiredArgsConstructor
public class GuestGroupRepositoryImpl implements GuestGroupRepository {

  private final GuestGroupJpaRepository jpaRepository;

  @Override
  public GuestGroupEntity save(final GuestGroup guestGroup) {
    return jpaRepository.save(GuestGroupMapper.INSTANCE.toGuestGroupEntity(guestGroup));
  }

  @Override
  public boolean existsByName(final String name) {
    return jpaRepository.existsByName(name);
  }
}
