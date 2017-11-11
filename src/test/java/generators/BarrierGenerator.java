package generators;

import java.time.LocalDateTime;

import dto.Barrier;
import dto.BarrierState;
import net.ugolok.generation.annotations.Generate;
import net.ugolok.generation.annotations.Generator;
import net.ugolok.generation.providers.DateTimeProvider;
import net.ugolok.generation.providers.IntegerProvider;
import net.ugolok.generation.providers.LongProvider;
import net.ugolok.generation.providers.TimestampProvider;
import providers.BarrierStateProvider;

@Generator
public class BarrierGenerator {
	public static final long MIN_PERIOD = 40000;
	public static final long MAX_PERIOD = 90000;
	public static final int N_QUANTITY = 10;

	@Generate(provider = LongProvider.class, unique = true, quantity = N_QUANTITY)
	long id;

	@Generate(provider = BarrierStateProvider.class)
	BarrierState state;

	@Generate(provider = TimestampProvider.class)
	long timestamp;

	@Generate(provider = DateTimeProvider.class, minStr = "1940-01-01 18:18", maxStr = "2000-01-01 05:05")
	LocalDateTime dateTime;

	@Generate(provider = IntegerProvider.class, min = MIN_PERIOD, max = MAX_PERIOD)
	int period;

	public Barrier getDto() {
		return new Barrier(id, state, timestamp, dateTime, period);
	}
}
