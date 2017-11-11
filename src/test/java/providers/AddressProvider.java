package providers;

import java.util.Iterator;

import javax.naming.ConfigurationException;

import dto.Address;
import generators.AddressGenerator;
import net.ugolok.generation.JROFactory;
import net.ugolok.generation.providers.api.AbstractProvider;
import net.ugolok.generation.providers.api.Provider;

public class AddressProvider extends AbstractProvider<Address> {

	public AddressProvider() {
		super();
	}

	@Override
	public Iterator<Address> iterator() {
		JROFactory<AddressGenerator> factory;
		try {
			factory = JROFactory.create(AddressGenerator.class);
			Iterator<AddressGenerator> iterator = factory.iterator();

			return new Iterator<Address>() {

				@Override
				public boolean hasNext() {
					return iterator.hasNext();
				}

				@Override
				public Address next() {
					return iterator.next().getDto();
				}

			};

		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Provider<Address> setUnique(boolean unique) {
		return this;
	}

}
