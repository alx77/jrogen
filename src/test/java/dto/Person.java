package dto;

import java.time.LocalDate;

public class Person {
    protected int id;

    protected String name;

    protected Address address;

    protected LocalDate birthDate;

    protected String phone;

    public Person() {
        super();
    }

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

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", address=" + address + ", birthDate=" + birthDate + ", phone="
                + phone + "]";
    }
}
