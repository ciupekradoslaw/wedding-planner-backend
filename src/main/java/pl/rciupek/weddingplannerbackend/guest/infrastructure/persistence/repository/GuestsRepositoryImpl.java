package pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import pl.rciupek.weddingplannerbackend.common.model.PagedResult;
import pl.rciupek.weddingplannerbackend.guest.domain.model.Guest;
import pl.rciupek.weddingplannerbackend.guest.domain.repository.GuestRepository;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.mapper.GuestEntityMapper;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.entity.GuestEntity;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.repository.jpa.GuestJpaRepository;

@Repository
@RequiredArgsConstructor
public class GuestsRepositoryImpl implements GuestRepository {

  private final GuestJpaRepository guestJpaRepository;
  private final GuestEntityMapper guestEntityMapper;

  @Override
  public PagedResult<Guest> findAll(final int page, final int size) {
    final PageRequest pageRequest = PageRequest.of(page, size);
    final Page<GuestEntity> result = guestJpaRepository.findAll(pageRequest);

    return new PagedResult<>(
        result.getContent().stream()
            .map(guestEntityMapper::toDomain)
            .toList(),
        result.getNumber(),
        result.getSize(),
        result.getTotalElements()
    );
  }
}
