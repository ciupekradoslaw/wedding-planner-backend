package pl.rciupek.weddingplannerbackend.guest_group.application.model;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record AddGuestGroupResponse(UUID id, UUID token, String name) {
}
