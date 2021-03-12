package net.ugolok.generation.providers.api;

public interface Provider<T> extends Iterable<T> {
    Provider<T> setMax(long value);

    Provider<T> setMin(long value);

    Provider<T> setMinStr(String value);

    Provider<T> setMaxStr(String value);

    int getQuantity();

    Provider<T> setQuantity(int quantity);

    Provider<T> setUnique(boolean unique);

    Provider<T> setParameters(String[] parameters);

    Provider<T> setDataSource(String source);
}
