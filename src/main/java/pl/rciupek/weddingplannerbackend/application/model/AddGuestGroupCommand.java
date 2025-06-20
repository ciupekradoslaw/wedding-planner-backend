package pl.rciupek.weddingplannerbackend.application.model;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record AddGuestGroupCommand(String name, List<String> guestNames) {
}
