package pl.rciupek.weddingplannerbackend.guest_group.application.service;

import lombok.RequiredArgsConstructor;
import pl.rciupek.weddingplannerbackend.common.annotation.UseCase;
import pl.rciupek.weddingplannerbackend.common.exception.GuestGroupAlreadyExistsException;
import pl.rciupek.weddingplannerbackend.guest_group.application.model.AddGuestGroupCommand;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.guest_group.domain.repository.GuestGroupRepository;

@UseCase
@RequiredArgsConstructor
public class AddGuestGroupUseCase {

  private final GuestGroupRepository guestGroupRepository;

  public GuestGroup execute(final AddGuestGroupCommand command) {
    if (guestGroupRepository.existsByName(command.name())) {
      throw new GuestGroupAlreadyExistsException(command.name());
    }

    final GuestGroup guestGroup = new GuestGroup(command.name(), command.guestNames());
    return guestGroupRepository.save(guestGroup);
  }
}
