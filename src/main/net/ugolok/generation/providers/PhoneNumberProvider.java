package net.ugolok.generation.providers;

import java.util.Iterator;

import net.ugolok.generation.RandomArrayStreamer;
import net.ugolok.generation.providers.api.AbstractRandomProvider;

public class PhoneNumberProvider extends AbstractRandomProvider<String> {
	static private String[] codes = { "050", "052", "053", "054", "057", "058" };
	static private Iterator<String> codeIterator = RandomArrayStreamer.streamify(codes, 0, codes.length, false)
			.iterator();

	public PhoneNumberProvider() {
		super();
	}

	public void setCodes(String[] codes) {
		PhoneNumberProvider.codes = codes;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public String next() {
				return String.format("%s-%07d", codeIterator.next(), randomGenerator.nextInt(9999999));
			}
		};
	}
}
