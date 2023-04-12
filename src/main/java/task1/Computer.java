package task1;

public class Computer {
    private ComputerHardware computerHardware;

    public Computer(ComputerHardware computerHardware) {
        this.computerHardware = computerHardware;
    }

    public void setComputerHardware(ComputerHardware computerHardware) {
        this.computerHardware = computerHardware;
    }

    public void computerWorks(){
        computerHardware.turnOn();
        System.out.println("Computer works");
    }
}
