package pl.rciupek.weddingplannerbackend.auth.application.model;

import lombok.Builder;

@Builder
public record LoginCommand(String username, String password) {
}
