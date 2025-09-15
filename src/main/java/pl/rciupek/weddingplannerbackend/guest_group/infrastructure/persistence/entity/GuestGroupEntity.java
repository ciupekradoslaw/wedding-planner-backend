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
  @Column(nullable = false, name = "GG_ID")
  private UUID id;

  @Column(nullable = false, name = "GG_NAME")
  private String name;

  @Column(nullable = false, name = "GG_TOKEN")
  private UUID token;

  @OneToMany(mappedBy = "guestGroup", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<GuestEntity> members;
}
