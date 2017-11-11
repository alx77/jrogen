package providers;

import java.util.Iterator;

import dto.BarrierState;
import net.ugolok.generation.providers.api.AbstractRandomProvider;
import net.ugolok.generation.providers.api.Provider;

public class BarrierStateProvider extends AbstractRandomProvider<BarrierState> implements Provider<BarrierState> {

	public BarrierStateProvider() {
		super();
	}

	@Override
	public Iterator<BarrierState> iterator() {
		return new Iterator<BarrierState>() {

			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public BarrierState next() {
				return BarrierState.values()[randomGenerator.nextInt(BarrierState.values().length)];
			}

		};
	}

}