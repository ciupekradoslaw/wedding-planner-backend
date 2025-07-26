package pl.rciupek.weddingplannerbackend.user.domain.model;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class User {

  private UserId id;
  private String username;
  private String password;
  private Role role;

  public User(final String username, final String password, final Role role) {
    Assert.notNull(username, "Username must not be null");
    Assert.notNull(password, "Password must not be null");
    Assert.notNull(role, "Role must not be null");
    this.id = new UserId();
    this.username = username;
    this.password = password;
    this.role = role;
  }
}
