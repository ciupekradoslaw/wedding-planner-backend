package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.exposition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rciupek.weddingplannerbackend.guest_group.application.model.AddGuestGroupCommand;
import pl.rciupek.weddingplannerbackend.guest_group.application.model.AddGuestGroupRequestDto;
import pl.rciupek.weddingplannerbackend.guest_group.application.model.AddGuestGroupResponseDto;
import pl.rciupek.weddingplannerbackend.guest_group.application.service.AddGuestGroupUseCase;
import pl.rciupek.weddingplannerbackend.guest_group.domain.model.GuestGroup;

@RestController
@RequestMapping("/api/guest-groups")
@RequiredArgsConstructor
public class GuestGroupController {

  private final AddGuestGroupUseCase addGuestGroupUseCase;

  @PostMapping("/add")
  public ResponseEntity<AddGuestGroupResponseDto> addGuestGroup(@RequestBody final AddGuestGroupRequestDto request) {
    final GuestGroup guestGroup = addGuestGroupUseCase.execute(new AddGuestGroupCommand(request.name(), request.guestNames()));
    final AddGuestGroupResponseDto response = AddGuestGroupResponseDto.builder()
        .id(guestGroup.getId().id())
        .name(guestGroup.getName())
        .token(guestGroup.getToken().token())
        .build();

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(response);
  }

  @GetMapping()
  public ResponseEntity<String> getAllGuestGroups() {
    return ResponseEntity.ok("todo");
  }
}
