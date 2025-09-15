package pl.rciupek.weddingplannerbackend.common.model;

import java.util.List;
import java.util.function.Function;

public record PagedResult<T>(
    List<T> content,
    int page,
    int size,
    long totalElements
) {

  public int totalPages() {
    return (int) Math.ceil((double) totalElements / (double) size);
  }

  public <R> PagedResult<R> map(final Function<T, R> mapper) {
    final List<R> mappedContent = content.stream().map(mapper).toList();

    return new PagedResult<>(mappedContent, page, size, totalElements);
  }
}
