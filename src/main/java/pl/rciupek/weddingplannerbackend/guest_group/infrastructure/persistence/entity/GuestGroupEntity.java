package pl.rciupek.weddingplannerbackend.guest_group.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.entity.GuestEntity;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "T_GUEST_GROUP_GG")
@Data
public class GuestGroupEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(nullable = false, name = "GG_ID", columnDefinition = "VARCHAR2(36)")
  private String id;

  @Column(nullable = false, name = "GG_NAME", columnDefinition = "VARCHAR2(255)")
  private String name;

  @Column(nullable = false, name = "GG_TOKEN", columnDefinition = "VARCHAR2(36)")
  private UUID token;

  @OneToMany(mappedBy = "guestGroup", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<GuestEntity> members;
}
