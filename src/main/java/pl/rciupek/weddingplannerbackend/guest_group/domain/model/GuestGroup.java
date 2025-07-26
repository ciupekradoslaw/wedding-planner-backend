package pl.rciupek.weddingplannerbackend.guest_group.domain.model;

import lombok.Getter;
import org.springframework.util.Assert;
import pl.rciupek.weddingplannerbackend.guest.domain.model.Guest;

import java.util.List;

@Getter
public class GuestGroup {
  private GuestGroupId id;
  private String name;
  private GuestGroupToken token;
  private List<Guest> members;

  public GuestGroup(final String name, final List<String> guestNames) {
    Assert.notNull(name, "Guest Group name must not be null");
    Assert.notNull(guestNames, "Guest group names must not be empty");
    Assert.notEmpty(guestNames, "Guest Group members must not be empty");
    this.id = new GuestGroupId();
    this.name = name;
    this.token = new GuestGroupToken();
    this.members = guestNames.stream()
        .map(Guest::new)
        .toList();
  }
}
