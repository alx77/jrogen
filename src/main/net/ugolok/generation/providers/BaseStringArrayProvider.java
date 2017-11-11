package net.ugolok.generation.providers;

import java.util.Iterator;

import net.ugolok.generation.RandomArrayStreamer;
import net.ugolok.generation.providers.api.AbstractRandomProvider;

public class BaseStringArrayProvider extends AbstractRandomProvider<String> {
	protected String[] input = null;

	public BaseStringArrayProvider() {
		super();
	}

	public BaseStringArrayProvider(String[] input) {
		this.input = input;
	}

	@Override
	public Iterator<String> iterator() {
		return RandomArrayStreamer.streamify(input, quantity, max, unique).iterator();
	}

	public void setInput(String[] input) {
		this.input = input;
	}
}
