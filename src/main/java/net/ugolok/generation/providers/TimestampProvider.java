package net.ugolok.generation.providers;

import net.ugolok.generation.providers.api.Provider;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimestampProvider extends LongProvider {

    public TimestampProvider() {
        super();
        min = 0;
        max = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond() * 1000;//in millis
    }

    @Override
    public Provider<Long> setMinStr(String value) {

        min = "".equals(value) ? 0 : LocalDateTime.parse(value).atZone(ZoneId.systemDefault()).toEpochSecond() * 1000;
        return this;
    }

    @Override
    public Provider<Long> setMaxStr(String value) {
        max = ("".equals(value) ? LocalDateTime.now() : LocalDateTime.parse(value)).atZone(ZoneId.systemDefault())
                .toEpochSecond() * 1000;
        return this;
    }

}
