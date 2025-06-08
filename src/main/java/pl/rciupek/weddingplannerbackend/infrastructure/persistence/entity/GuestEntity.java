package pl.rciupek.weddingplannerbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "T_GUEST_G")
@Data
public class GuestEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(nullable = false, name = "G_ID")
  private UUID id;

  @Column(nullable = false, name = "G_NAME")
  private String name;

  @Column(nullable = false, name = "G_ATTENDING")
  private Boolean attending;

  @ManyToOne
  @JoinColumn(name = "G_GUEST_GROUP_ID")
  private GuestGroupEntity guestGroup;
}
