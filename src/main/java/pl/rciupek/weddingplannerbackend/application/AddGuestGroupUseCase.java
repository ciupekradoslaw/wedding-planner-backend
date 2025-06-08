package pl.rciupek.weddingplannerbackend.application;

import lombok.RequiredArgsConstructor;
import pl.rciupek.weddingplannerbackend.application.model.AddGuestGroupCommand;
import pl.rciupek.weddingplannerbackend.domain.guest.model.Guest;
import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroup;
import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroupId;
import pl.rciupek.weddingplannerbackend.domain.guest_group.model.GuestGroupToken;
import pl.rciupek.weddingplannerbackend.domain.guest_group.repository.GuestGroupRepository;
import pl.rciupek.weddingplannerbackend.util.annotation.UseCase;

@UseCase
@RequiredArgsConstructor
public class AddGuestGroupUseCase {

  private final GuestGroupRepository guestGroupRepository;

  public GuestGroupToken execute(final AddGuestGroupCommand command) {
    final GuestGroup guestGroup = new GuestGroup(command.name(), command.guestNames());
    return null; // TODO
  }
}
