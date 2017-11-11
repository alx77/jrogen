package test;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Map;

import javax.naming.ConfigurationException;

import org.junit.Test;

import dto.Barrier;
import generators.BarrierGenerator;
import net.ugolok.generation.JROFactory;
import net.ugolok.generation.providers.api.Provider;

public class DynamicGenerationTest {
	public static final int BARRIER_PERIOD = 30000;

	@Test
	public void dynamicTest() throws ConfigurationException {
		JROFactory<BarrierGenerator> factory = JROFactory.create(BarrierGenerator.class);

		Map<String, Provider<?>> generators = factory.getGenerators();

		long currentTime = System.currentTimeMillis();
		generators.get("timestamp").setMin(currentTime);
		generators.get("timestamp").setMax(currentTime + BARRIER_PERIOD);

		Iterator<BarrierGenerator> barrierIterator = factory.iterator();

		while (barrierIterator.hasNext()) {

			Barrier b = barrierIterator.next().getDto();
			assertTrue(b.getTimestamp() >= currentTime && b.getTimestamp() <= (currentTime + BARRIER_PERIOD));
		}
	}

}
