package pl.rciupek.weddingplannerbackend.user.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_USER_U")
public class UserEntity implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(nullable = false, name = "U_ID", columnDefinition = "VARCHAR2(36)")
  private String id;

  @Column(nullable = false, name = "U_USERNAME", columnDefinition = "VARCHAR2(255)")
  private String username;

  @Column(nullable = false, name = "U_PASSWORD", columnDefinition = "VARCHAR2(255)")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, name = "U_ROLE", columnDefinition = "VARCHAR2(50)")
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
