[![Build Status](https://travis-ci.org/alx77/jrogen.svg?branch=master)](https://travis-ci.org/alx77/jrogen)

# jrogen
## Java Random Object Generator

### Requirements:
* **Java 8**

Sometimes you need to create a set of random (or partially random) objects of some class (like DTO/POJO etc). You know everything about allowed ranges/values of this object's fields but don't want waste your time to implement this kind of logic. Probably this small library with annotations will help you.

So, firstly create simple POJO object like this:
```
public class Person {
	protected int id;
	protected String name;
	protected Address address;
	protected LocalDate birthDate;
	protected String phone;

	public Person(int id, String name, Address address, LocalDate birthDate, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

//..... place another getters/setters/etc. here
}
```
... and create corresponding generating object:
```
@Generator
public class PersonGenerator {
	public static final int N_PERSONS = 20;
	public static final int MIN_PERSON_ID = 1, MAX_PERSON_ID = 100;

	@Generate(provider = IntegerProvider.class, min = MIN_PERSON_ID, max = MAX_PERSON_ID, unique = true, quantity = N_PERSONS)
	int id;

	@Generate(provider = FileStringProvider.class, source = "names.dta")
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
```
As you can see, we can instantiate our data with several random data providers like `IntegerProvider` or more complicated ones to generate another objects like `AddressProvider`. You can generate not only a random values but series of unique (and randomly arranged) values (for example, to use them as ID's of your objects). Also you can create your own project-specific data providers for your purposes.

At the end you can generate as much objects of required class as you need (or as you specified in `@Generate` line).
```
Iterator<PersonGenerator> iterator = JROFactory.create(PersonGenerator.class).iterator();

while (iterator.hasNext()) {
	Person p = iterator.next().getDto();
	System.out.println(p);
}
```

Unfortunately, sometimes you need to calculate the ranges for a several fields of your entity in runtime, but there isn't ability  to supply non-constant values to an annotation line. To have ability to specify these values dynamically you can use the following approach:
```
JROFactory<PersonGenerator> factory = JROFactory.create(PersonGenerator.class);

Map<String, Provider<?>> generators = factory.getGenerators();

generators.get("id").setMin(1000);
generators.get("id").setMax(2000);

Iterator<PersonGenerator> iterator = factory.iterator();
while (iterator.hasNext()) {
	Person p = iterator.next().getDto();
	System.out.println(p);
}
```
Use and enjoy! And of course all your suggestions are welcome!:sunflower:
