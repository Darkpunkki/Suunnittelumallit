package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    public void addCPU() {
        computer.addComponent(new Component("Intel Core i5"));
    }

    public void addRAM() {
        computer.addComponent(new Component("8GB DDR4"));
    }

    public void addHDD() {
        computer.addComponent(new Component("1TB HDD"));
    }

    public void addGPU() {
        computer.addComponent(new Component("Intel UHD Graphics 630"));
    }

    public void addOS() {
        computer.addComponent(new Component("Windows 10 Pro"));
    }

    public Computer getComputer() {
        return computer;
    }
}
