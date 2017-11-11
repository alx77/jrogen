package generators;

import java.time.LocalDate;

import dto.Address;
import dto.Person;
import net.ugolok.generation.annotations.Generate;
import net.ugolok.generation.annotations.Generator;
import net.ugolok.generation.providers.DateProvider;
import net.ugolok.generation.providers.FileStringProvider;
import net.ugolok.generation.providers.IntegerProvider;
import net.ugolok.generation.providers.PhoneNumberProvider;
import providers.AddressProvider;

@Generator
public class PersonGenerator {
	public static final int N_PERSONS = 20;
	public static final int MIN_PERSON_ID = 1;
	public static final int MAX_PERSON_ID = 100;

	@Generate(provider = IntegerProvider.class, min = MIN_PERSON_ID, max = MAX_PERSON_ID, unique = true, quantity = N_PERSONS)
	int id;

	@Generate(provider = FileStringProvider.class, source = "isr-names.dta")
	String name;

	@Generate(provider = AddressProvider.class)
	Address address;

	@Generate(provider = DateProvider.class, minStr = "1940-01-01", maxStr = "2000-01-01")
	LocalDate birthDate;

	@Generate(provider = PhoneNumberProvider.class)
	String phone;

	public Person getDto() {
		return new Person(id, name, address, birthDate, phone);
	}
}
