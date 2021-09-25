package com.learning.corejava;

/**
 * Note:
 * 1) The class must be declared as final (So that child classes can’t be created)
 * 2) Data members in the class must be declared as private (So that direct access is not allowed)
 * 3) Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
 * 4) A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference)
 * 5) Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
 */
public final class ImmutableClassEx {
    private final int id;
    private final String name;
    private final Address address;

    public ImmutableClassEx(int id, String name, Address address) throws CloneNotSupportedException {
        this.id = id;
        this.name = name;
        // this.address = address.clone(); // OR
        Address cloneAddress = new Address(address.getStreet(), address.getCity(), address.getState(), address.getPostalCode());
        this.address = cloneAddress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() throws CloneNotSupportedException {
        // return address.clone(); // OR
        Address cloneAddress = new Address(address.getStreet(), address.getCity(), address.getState(), address.getPostalCode());
        return cloneAddress;
    }

    // for testing
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Street1", "City1", "State1", 123456);
        ImmutableClassEx immutableClassEx = new ImmutableClassEx(1, "Name1", address);

        // 1) changing state of input address reference
        address.setStreet("Street1 Edit1");
        System.out.println(immutableClassEx.getAddress().getStreet());  // should print 'Street1' not 'Street1 Edit1'

        // 2) changing state of output address reference
        Address address1 = immutableClassEx.getAddress();
        address1.setStreet("Street1 Edit2");
        System.out.println(immutableClassEx.getAddress().getStreet());  // should print 'Street1' not 'Street1 Edit2'
    }
}

class Address implements Cloneable {
    private String street;
    private String city;
    private String state;
    private int postalCode;

    public Address(String street, String city, String state, int postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
