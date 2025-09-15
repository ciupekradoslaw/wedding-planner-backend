package pl.rciupek.weddingplannerbackend.guest.application.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public record GuestResponseDto(UUID id, String name, boolean attending) {
}
