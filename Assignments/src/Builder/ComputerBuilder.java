package Builder;

public interface ComputerBuilder {
    void addCPU();
    void addRAM();
    void addHDD();
    void addGPU();
    void addOS();
    Computer getComputer();
}

