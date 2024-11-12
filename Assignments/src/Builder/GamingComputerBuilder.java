package Builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    public void addCPU() {
        computer.addComponent(new Component("Intel Core i9-9900K"));
    }

    public void addRAM() {
        computer.addComponent(new Component("Corsair Vengeance LPX 16GB"));
    }

    public void addHDD() {
        computer.addComponent(new Component("Seagate Barracuda 2TB"));
    }

    public void addGPU() {
        computer.addComponent(new Component("Nvidia GeForce RTX 3080 Ti"));
    }

    public void addOS() {
        computer.addComponent(new Component("Windows 11 Pro"));
    }

    public Computer getComputer() {
        return computer;
    }
}
