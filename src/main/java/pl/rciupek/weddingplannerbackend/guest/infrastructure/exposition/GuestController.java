package pl.rciupek.weddingplannerbackend.guest.infrastructure.exposition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.rciupek.weddingplannerbackend.common.model.PagedResult;
import pl.rciupek.weddingplannerbackend.guest.application.mapper.GuestMapper;
import pl.rciupek.weddingplannerbackend.guest.application.model.GuestResponseDto;
import pl.rciupek.weddingplannerbackend.guest.application.services.GetGuestsUseCase;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {

  private final GetGuestsUseCase getGuestsUseCase;
  private final GuestMapper guestMapper;

  @GetMapping()
  public ResponseEntity<PagedResult<GuestResponseDto>> getGuests(@RequestParam(defaultValue = "1") final int page,
                                                                 @RequestParam(defaultValue = "10") final int size) {
    final PagedResult<GuestResponseDto> result = getGuestsUseCase.findAll(page, size)
        .map(guestMapper::toResponseDto);
    return ResponseEntity.ok(result);
  }
}
