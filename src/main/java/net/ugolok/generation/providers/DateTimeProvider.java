package net.ugolok.generation.providers;

import net.ugolok.generation.providers.api.AbstractRandomProvider;
import net.ugolok.generation.providers.api.Provider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

public class DateTimeProvider extends AbstractRandomProvider<LocalDateTime> {
    LocalDateTime minDateTime = LocalDateTime.of(1970, 1, 1, 1, 1);
    LocalDateTime maxDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public DateTimeProvider() {
        super();
    }

    @Override
    public Iterator<LocalDateTime> iterator() {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDateTime next() {
                long seconds = ChronoUnit.SECONDS.between(minDateTime, maxDateTime);

                return minDateTime.plusSeconds((long) (randomGenerator.nextDouble() * seconds));
            }
        };
    }

    @Override
    public Provider<LocalDateTime> setMinStr(String value) {
        minDateTime = LocalDateTime.parse(value, formatter);
        return this;
    }

    @Override
    public Provider<LocalDateTime> setMaxStr(String value) {
        maxDateTime = LocalDateTime.parse(value, formatter);
        return this;
    }
}
