package pl.rciupek.weddingplannerbackend.domain.guest.model;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Guest {
  private GuestId id;
  private String name;
  private boolean attending;

  public Guest(final String name) {
    Assert.notNull(name, "Guest name must not be null");
    this.id = new GuestId();
    this.name = name;
    this.attending = false;
  }

  public void confirmAttendance() {
    this.attending = true;
  }

  public void cancelAttendance() {
    this.attending = false;
  }
}
