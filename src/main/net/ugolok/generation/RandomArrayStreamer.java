package net.ugolok.generation;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface RandomArrayStreamer {
	public static <T> Stream<T> streamify(List<T> input, int quantity, long maxRangeValue, boolean unique) {
		@SuppressWarnings("unchecked")
		final T[] a = (T[]) new Object[input.size()];
		input.toArray(a);
		return streamify(a, quantity, maxRangeValue, unique);
	}

	public static <T> Stream<T> streamify(T[] input, int quantity, long maxRangeValue, boolean unique) {
		if (unique) {
			int allowedQuantity = (quantity == 0 || input.length < quantity) ? input.length : quantity;
			List<Integer> numbers = IntStream.range(0, allowedQuantity).boxed().collect(Collectors.toList());
			Collections.shuffle(numbers);
			return numbers.stream().map(x -> input[x]);
		} else {
			int allowedMaxRange = (input.length < maxRangeValue) ? input.length : (int) maxRangeValue;
			IntStream stream = new Random().ints(0, allowedMaxRange);
			if (quantity != 0) {
				stream = stream.limit(quantity);
			}
			return stream.boxed().map(x -> input[x]);
		}
	}
}
