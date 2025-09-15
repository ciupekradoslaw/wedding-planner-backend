package pl.rciupek.weddingplannerbackend.guest.domain.repository;

import pl.rciupek.weddingplannerbackend.common.model.PagedResult;
import pl.rciupek.weddingplannerbackend.guest.domain.model.Guest;

public interface GuestRepository {
  PagedResult<Guest> findAll(int page, int size);
}
