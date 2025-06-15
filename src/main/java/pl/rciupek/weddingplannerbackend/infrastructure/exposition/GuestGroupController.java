package pl.rciupek.weddingplannerbackend.infrastructure.exposition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.rciupek.weddingplannerbackend.application.AddGuestGroupUseCase;
import pl.rciupek.weddingplannerbackend.application.model.AddGuestGroupCommand;
import pl.rciupek.weddingplannerbackend.application.model.AddGuestGroupResponse;
import pl.rciupek.weddingplannerbackend.infrastructure.persistence.entity.GuestGroupEntity;

@RestController
@RequiredArgsConstructor
public class GuestGroupController {
  private static final String API_GUEST_GROUPS = "/api/guest-groups";

  private final AddGuestGroupUseCase addGuestGroupUseCase;

  @PostMapping(API_GUEST_GROUPS)
  public ResponseEntity<AddGuestGroupResponse> addGuestGroup(@RequestBody final AddGuestGroupCommand addGuestGroupCommand) {
    final GuestGroupEntity entity = addGuestGroupUseCase.execute(addGuestGroupCommand);
    final AddGuestGroupResponse response = AddGuestGroupResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .token(entity.getToken())
        .build();

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(response);
  }
}
