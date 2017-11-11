package net.ugolok.generation.providers;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import net.ugolok.generation.RandomArrayStreamer;
import net.ugolok.generation.providers.api.AbstractRandomProvider;
import net.ugolok.generation.providers.api.Provider;

public class LongProvider extends AbstractRandomProvider<Long> {
	List<Long> numbers;
	Iterator<Long> numbersIterator;

	public LongProvider() {
		super();
	}

	@Override
	public Iterator<Long> iterator() {
		if (unique) {
			if (max == Integer.MAX_VALUE) {
				max = min + quantity;
			}
			LongStream stream = LongStream.range(min, max);
			if (quantity != 0) {
				stream = stream.limit(quantity);
			}
			numbers = stream.boxed().collect(Collectors.toList());
			Collections.shuffle(numbers);

			numbersIterator = RandomArrayStreamer.streamify(numbers, quantity, max, unique).iterator();
		} else {
			LongStream stream = new Random().longs(min, max);
			if (quantity != 0) {
				stream = stream.limit(quantity);
			}
			numbersIterator = stream.iterator();
		}

		return new Iterator<Long>() {

			@Override
			public boolean hasNext() {
				return numbersIterator.hasNext();
			}

			@Override
			public Long next() {
				return numbersIterator.next();
			}

		};
	}

	@Override
	public Provider<Long> setUnique(boolean unique) {
		this.unique = unique;
		return this;
	}

}
