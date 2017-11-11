package net.ugolok.generation.providers.api;

import java.security.SecureRandom;

public abstract class AbstractRandomProvider<T> extends AbstractProvider<T> {
	protected boolean unique = false;
	static protected SecureRandom randomGenerator = new SecureRandom();

	@Override
	public Provider<T> setUnique(boolean unique) {
		this.unique = unique;
		return this;
	}

}
