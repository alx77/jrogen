package net.ugolok.generation.providers.api;

public abstract class AbstractProvider<T> implements Provider<T> {

	protected long min;
	protected long max;
	protected int quantity;
	protected String minStr;
	protected String maxStr;
	protected String dataSource;
	protected String[] parameters;

	public AbstractProvider() {
		super();
	}

	@Override
	public Provider<T> setParameters(String[] parameters) {
		this.parameters = parameters;
		return this;
	}

	@Override
	public Provider<T> setMax(long value) {
		max = value;
		return this;
	}

	@Override
	public Provider<T> setMin(long value) {
		min = value;
		return this;
	}

	@Override
	public Provider<T> setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public Provider<T> setMinStr(String value) {
		minStr = value;
		return this;
	}

	@Override
	public Provider<T> setMaxStr(String value) {
		maxStr = value;
		return this;
	}

	@Override
	public Provider<T> setDataSource(String dataSource) {
		this.dataSource = dataSource;
		return this;
	}

}