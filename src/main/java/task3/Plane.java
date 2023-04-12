package task3;

public class Plane {

    private String model;

    public void setModel(String model) {
        this.model = model;
    }
    public void flyThePlane(){
        System.out.println("The plane model " + model + " is flying");
    }
}
