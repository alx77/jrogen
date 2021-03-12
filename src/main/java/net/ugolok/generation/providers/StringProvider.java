package net.ugolok.generation.providers;

import net.ugolok.generation.providers.api.AbstractRandomProvider;

import java.util.Iterator;

public class StringProvider extends AbstractRandomProvider<String> {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public StringProvider() {
        super();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                int len = randomGenerator.nextInt((int) max - (int) min) + (int) min;
                StringBuilder sb = new StringBuilder(len);
                int strLen = AB.length();
                for (int i = 0; i < len; i++) {
                    sb.append(AB.charAt(randomGenerator.nextInt(strLen)));
                }
                return sb.toString();
            }
        };
    }
}
