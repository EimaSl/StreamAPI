package task1;

public class ComputerTesterMain {
    public static void main(String[] args) {

        AsusMotherboard asusMB = new AsusMotherboard();
        Computer computer = new Computer(asusMB);
        computer.computerWorks();

        MsiMotherboard msi = new MsiMotherboard();
        computer.setComputerHardware(msi);

        computer.computerWorks();
    }
}
