package pl.rciupek.weddingplannerbackend.infrastructure.mapper;

public interface IdMapper<T, R> {
  R toEntityId(final T value);
  T toDomainId(final R value);
}
