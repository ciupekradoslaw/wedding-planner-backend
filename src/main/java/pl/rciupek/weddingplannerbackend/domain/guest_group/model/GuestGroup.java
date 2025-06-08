package pl.rciupek.weddingplannerbackend.domain.guest_group.model;

import lombok.Getter;
import org.springframework.util.Assert;
import pl.rciupek.weddingplannerbackend.domain.guest.model.Guest;

import java.util.List;

@Getter
public class GuestGroup {
  private GuestGroupId id;
  private String name;
  private GuestGroupToken token;
  private List<Guest> members;

  public GuestGroup(final String name, final List<String> guestNames) {
    Assert.notNull(name, "Guest Group name must not be null");
    Assert.notEmpty(members, "Guest Group members must not be empty");
    this.id = new GuestGroupId();
    this.name = name;
    this.token = new GuestGroupToken();
    this.members = guestNames.stream()
        .map(Guest::new)
        .toList();
  }
}
