package pl.rciupek.weddingplannerbackend.application.model;

import java.util.List;

public record AddGuestGroupCommand(String name, List<String> guestNames) {
}
