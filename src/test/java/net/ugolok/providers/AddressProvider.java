package net.ugolok.providers;

import net.ugolok.dto.Address;
import net.ugolok.generators.AddressGenerator;
import net.ugolok.generation.JROFactory;
import net.ugolok.generation.providers.api.AbstractProvider;
import net.ugolok.generation.providers.api.Provider;

import javax.naming.ConfigurationException;
import java.util.Iterator;

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

            return new Iterator<>() {
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
