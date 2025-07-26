package pl.rciupek.weddingplannerbackend.auth.application.model;

import lombok.Builder;

@Builder
public record RegisterRequestDto(String username, String password) {
}
