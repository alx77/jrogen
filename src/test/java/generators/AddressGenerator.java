package generators;

import dto.Address;
import net.ugolok.generation.annotations.Generate;
import net.ugolok.generation.annotations.Generator;
import net.ugolok.generation.providers.FileStringProvider;
import net.ugolok.generation.providers.IntegerProvider;

@Generator
public class AddressGenerator {
	@Generate(provider = FileStringProvider.class, source = "isr-cities.dta")
	String city;

	@Generate(provider = FileStringProvider.class, source = "isr-streets.dta")
	String street;

	@Generate(provider = IntegerProvider.class, min = 1, max = 400)
	int building;

	@Generate(provider = IntegerProvider.class, min = 1, max = 500)
	int apartment;

	public Address getDto() {
		return new Address(city, street, building, apartment);
	}
}
