package pl.rciupek.weddingplannerbackend.common.exception;

public class GuestGroupAlreadyExistsException extends RuntimeException {

  public GuestGroupAlreadyExistsException(final String name) {
    super("Guest group with name " + name + " already exists");
  }
}
