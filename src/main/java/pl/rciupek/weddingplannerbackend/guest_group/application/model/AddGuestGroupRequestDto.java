package pl.rciupek.weddingplannerbackend.guest_group.application.model;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record AddGuestGroupRequestDto(String name, List<String> guestNames) {
}
