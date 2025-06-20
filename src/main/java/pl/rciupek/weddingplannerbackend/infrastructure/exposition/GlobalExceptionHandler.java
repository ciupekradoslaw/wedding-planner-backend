package pl.rciupek.weddingplannerbackend.infrastructure.exposition;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.rciupek.weddingplannerbackend.application.exception.GuestGroupAlreadyExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(GuestGroupAlreadyExistsException.class)
  public ResponseEntity<String> handleGuestGroupAlreadyExistsException(final GuestGroupAlreadyExistsException exception) {
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(exception.getMessage());
  }
}
