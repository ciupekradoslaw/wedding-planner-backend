package pl.rciupek.weddingplannerbackend.common.mapper;

public interface IdMapper<T, R> {
  R toEntityId(final T value);
  T toDomainId(final R value);
}
