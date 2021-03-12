package test;


import java.util.Iterator;
import java.util.Map;
import javax.naming.ConfigurationException;

import dto.Barrier;
import generators.BarrierGenerator;
import net.ugolok.generation.JROFactory;
import net.ugolok.generation.providers.api.Provider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicGenerationTest {
    public static final int BARRIER_PERIOD = 30000;

    @Test
    public void dynamicTest() throws ConfigurationException {
        JROFactory<BarrierGenerator> factory = JROFactory.create(BarrierGenerator.class);

        Map<String, Provider<?>> generators = factory.getGenerators();

        long currentTime = System.currentTimeMillis();
        generators.get("timestamp").setMin(currentTime);
        generators.get("timestamp").setMax(currentTime + BARRIER_PERIOD);

        for (BarrierGenerator barrierGenerator : factory) {
            Barrier b = barrierGenerator.getDto();
            assertTrue(b.getTimestamp() >= currentTime && b.getTimestamp() <= (currentTime + BARRIER_PERIOD));
        }
    }

}
