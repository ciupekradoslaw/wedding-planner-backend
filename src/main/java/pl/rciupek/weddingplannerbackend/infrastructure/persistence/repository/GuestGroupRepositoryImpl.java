package pl.rciupek.weddingplannerbackend.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.domain.guest_group.repository.GuestGroupRepository;

@Repository
@RequiredArgsConstructor
public class GuestGroupRepositoryImpl implements GuestGroupRepository {

  private final GuestGroupJpaRepository jpaRepository;

  @Override
  public void save(final GuestGroup guestGroup) {
//    jpaRepository.save(GuestGroupMapper)
  }

  @Override
  public boolean existsByName(final String name) {
    return jpaRepository.existsByName(name);
  }
}
