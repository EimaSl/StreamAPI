package task2;

public class School {

    private String name;
    private Address address;

    public void workingStatus (){
        System.out.println("School " + name + " is opened in " + address.getCity() + " city " + address.getStreet());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
