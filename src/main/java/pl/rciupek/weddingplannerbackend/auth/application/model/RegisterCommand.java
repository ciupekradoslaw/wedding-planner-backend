package pl.rciupek.weddingplannerbackend.auth.application.model;

import lombok.Builder;

@Builder
public record RegisterCommand(String username, String password) {
}
