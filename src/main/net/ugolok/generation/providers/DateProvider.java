package net.ugolok.generation.providers;

import net.ugolok.generation.providers.api.AbstractRandomProvider;
import net.ugolok.generation.providers.api.Provider;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

public class DateProvider extends AbstractRandomProvider<LocalDate> {
    LocalDate minDate = LocalDate.of(1970, 1, 1);
    LocalDate maxDate = LocalDate.now();

    public DateProvider() {
        super();
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                long days = ChronoUnit.DAYS.between(minDate, maxDate);
                Period p = Period.ofDays(randomGenerator.nextInt((int) days));

                return minDate.plus(p);
            }
        };
    }

    @Override
    public Provider<LocalDate> setMinStr(String value) {
        minDate = LocalDate.parse(value);
        return this;
    }

    @Override
    public Provider<LocalDate> setMaxStr(String value) {
        maxDate = LocalDate.parse(value);
        return this;
    }
}
