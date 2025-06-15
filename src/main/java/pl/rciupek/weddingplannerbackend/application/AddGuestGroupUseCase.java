package pl.rciupek.weddingplannerbackend.application;

import lombok.RequiredArgsConstructor;
import pl.rciupek.weddingplannerbackend.application.exception.GuestGroupAlreadyExistsException;
import pl.rciupek.weddingplannerbackend.application.model.AddGuestGroupCommand;
import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.domain.guest_group.repository.GuestGroupRepository;
import pl.rciupek.weddingplannerbackend.infrastructure.persistence.entity.GuestGroupEntity;
import pl.rciupek.weddingplannerbackend.util.annotation.UseCase;

@UseCase
@RequiredArgsConstructor
public class AddGuestGroupUseCase {

  private final GuestGroupRepository guestGroupRepository;

  public GuestGroupEntity execute(final AddGuestGroupCommand command) {
    if (guestGroupRepository.existsByName(command.name())) {
      throw new GuestGroupAlreadyExistsException(command.name());
    }

    final GuestGroup guestGroup = new GuestGroup(command.name(), command.guestNames());
    return guestGroupRepository.save(guestGroup);
  }
}
