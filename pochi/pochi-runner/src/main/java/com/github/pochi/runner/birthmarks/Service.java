package com.github.pochi.runner.birthmarks;

import java.util.Optional;
import java.util.stream.Stream;

@FunctionalInterface
public interface Service<S> {
    S type();

    default <T> Stream<T> filter(Stream<Optional<T>> stream){
        return stream.filter(Optional::isPresent)
                .map(Optional::get);
    }
}
