package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.exposition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.rciupek.weddingplannerbackend.guest_group.application.AddGuestGroupUseCase;
import pl.rciupek.weddingplannerbackend.guest_group.application.model.AddGuestGroupCommand;
import pl.rciupek.weddingplannerbackend.guest_group.application.model.AddGuestGroupResponse;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroup;

@RestController
@RequiredArgsConstructor
public class GuestGroupController {
  private static final String API_GUEST_GROUPS = "/api/guest-groups";

  private final AddGuestGroupUseCase addGuestGroupUseCase;

  @PostMapping(API_GUEST_GROUPS)
  public ResponseEntity<AddGuestGroupResponse> addGuestGroup(@RequestBody final AddGuestGroupCommand addGuestGroupCommand) {
    final GuestGroup guestGroup = addGuestGroupUseCase.execute(addGuestGroupCommand);
    final AddGuestGroupResponse response = AddGuestGroupResponse.builder()
        .id(guestGroup.getId().id())
        .name(guestGroup.getName())
        .token(guestGroup.getToken().token())
        .build();

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(response);
  }
}
