package pl.rciupek.weddingplannerbackend.guest.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.rciupek.weddingplannerbackend.guest_group.infrastructure.persistence.entity.GuestGroupEntity;

@Entity
@Table(name = "T_GUEST_G")
@Data
public class GuestEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(nullable = false, name = "G_ID", columnDefinition = "VARCHAR2(36)")
  private String id;

  @Column(nullable = false, name = "G_NAME", columnDefinition = "VARCHAR2(255)")
  private String name;

  @Column(nullable = false, name = "G_ATTENDING", columnDefinition = "NUMBER(1)")
  private Boolean attending;

  @ManyToOne
  @JoinColumn(name = "G_GUEST_GROUP_ID")
  private GuestGroupEntity guestGroup;
}
