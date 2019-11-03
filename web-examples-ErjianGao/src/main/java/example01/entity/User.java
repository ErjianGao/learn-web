package example01.entity;

public class User {
    private String name;
    private Address address;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
