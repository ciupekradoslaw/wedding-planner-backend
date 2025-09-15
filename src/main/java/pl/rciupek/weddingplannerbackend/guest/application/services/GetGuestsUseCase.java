package pl.rciupek.weddingplannerbackend.guest.application.services;

import lombok.RequiredArgsConstructor;
import pl.rciupek.weddingplannerbackend.common.annotation.UseCase;
import pl.rciupek.weddingplannerbackend.common.model.PagedResult;
import pl.rciupek.weddingplannerbackend.guest.domain.model.Guest;
import pl.rciupek.weddingplannerbackend.guest.domain.repository.GuestRepository;

@UseCase
@RequiredArgsConstructor
public class GetGuestsUseCase {

  private final GuestRepository guestRepository;

  public PagedResult<Guest> findAll(final int page, final int size) {
    return guestRepository.findAll(page, size);
  }
}
