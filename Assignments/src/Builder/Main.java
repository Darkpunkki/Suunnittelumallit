package Builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder officePcBuilder = new OfficeComputerBuilder();
        ComputerBuilder gamingPcBuilder = new GamingComputerBuilder();

        ComputerDirector computerDirector = new ComputerDirector(officePcBuilder);
        computerDirector.construct();
        Computer officeComputer = officePcBuilder.getComputer();

        System.out.println("Office PC: \n" + officeComputer);

        computerDirector = new ComputerDirector(gamingPcBuilder);
        computerDirector.construct();
        Computer gamingComputer = gamingPcBuilder.getComputer();

        System.out.println("Gaming PC: \n" + gamingComputer);
    }
}
