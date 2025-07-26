package pl.rciupek.weddingplannerbackend.auth.application.model;

import lombok.Builder;

@Builder
public record LoginRequestDto(String username, String password) {
}
