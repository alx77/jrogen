package dto;

public class Address {
    protected String city;

    protected String street;

    protected int building;

    protected int apartment;

    public Address() {
        super();
    }

    public Address(String city, String street, int building, int apartment) {
        super();
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", street=" + street + ", building=" + building + ", apartment=" + apartment
                + "]";
    }
}
