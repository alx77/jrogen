package net.ugolok.generation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.naming.ConfigurationException;

import net.ugolok.generation.annotations.Generate;
import net.ugolok.generation.annotations.Generator;
import net.ugolok.generation.providers.api.Provider;

public class JROFactory<T> implements Iterable<T> {

	Map<String, Provider<?>> providers = new HashMap<>();
	Class<T> clazz;

	public static <T> JROFactory<T> create(Class<T> clazz) throws ConfigurationException {
		return new JROFactory<>(clazz);
	}

	JROFactory(Class<T> clazz) throws ConfigurationException {
		Generator builtAnnotation = clazz.getAnnotation(Generator.class);
		if (builtAnnotation != null) {
			this.clazz = clazz;
			Field fields[] = clazz.getDeclaredFields();
			for (Field field : fields) {
				setupField(field);
			}
		} else
			throw new ConfigurationException("Generated annotation not found");
	}

	private void setupField(Field field) {
		Generate generate = field.getAnnotation(Generate.class);
		if (generate != null) {
			try {
				Provider<?> provider = (Provider<?>) generate.provider().newInstance();
				provider.setMax(generate.max()).setMin(generate.min()).setQuantity(generate.quantity())
						.setMaxStr(generate.maxStr()).setMinStr(generate.minStr()).setUnique(generate.unique())
						.setDataSource(generate.source()).setParameters(generate.params());
				providers.put(field.getName(), provider);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public Map<String, Provider<?>> getGenerators() {
		return providers;
	}

	@Override
	public Iterator<T> iterator() {
		Map<String, Iterator<?>> iterators = providers.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().iterator()));

		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				for (Iterator<?> iterator : iterators.values()) {
					if (!iterator.hasNext())
						return false;
				}
				return true;
			}

			@Override
			public T next() {
				T obj = null;
				try {
					obj = clazz.newInstance();
					for (Entry<String, Iterator<?>> entry : iterators.entrySet()) {
						Field declaredField = clazz.getDeclaredField(entry.getKey());
						boolean accessible = declaredField.isAccessible();

						declaredField.setAccessible(true);
						Iterator<?> provider = entry.getValue();
						declaredField.set(obj, provider.next());

						declaredField.setAccessible(accessible);
					}
				} catch (NoSuchFieldException | SecurityException | IllegalAccessException | InstantiationException e) {
					e.printStackTrace();

				}
				return obj;
			}
		};
	}

}
