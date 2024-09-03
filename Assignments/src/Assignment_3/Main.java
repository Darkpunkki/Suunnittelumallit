package Assignment_3;

import Assignment_3.component.Unit;
import Assignment_3.leaf.Employee;
import Assignment_3.composite.Department;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Employees

        Unit employee1 = new Employee("John", 1000);
        Unit employee2 = new Employee("David", 1500);
        Unit employee3 = new Employee("Sophia", 2000);
        Unit employee4 = new Employee("Emma", 2500);
        Unit employee5 = new Employee("Olivia", 1800);
        Unit employee6 = new Employee("James", 1200);
        Unit employee7 = new Employee("William", 1700);
        Unit employee8 = new Employee("Isabella", 2100);

        // Departments

        Department hrDepartment = new Department("HR");
        Department itDepartment = new Department("IT");
        Department financeDepartment = new Department("Finance");
        Department recruitmentDepartment = new Department("Recruitment");
        Department bossDepartment = new Department("Head Office");

        hrDepartment.add(employee1);
        hrDepartment.add(employee8);
        itDepartment.add(employee2);
        itDepartment.add(employee6);
        financeDepartment.add(employee3);
        financeDepartment.add(employee7);
        financeDepartment.add(employee4);

        bossDepartment.add(hrDepartment);
        bossDepartment.add(itDepartment);
        bossDepartment.add(financeDepartment);


        System.out.println("Salary per Department:");
        System.out.println("HR: " + hrDepartment.getSalary());
        System.out.println("IT: " + itDepartment.getSalary());
        System.out.println("Finance: " + financeDepartment.getSalary());
        System.out.println(" ");
        System.out.println("Total salary: " + bossDepartment.getSalary());
        System.out.println("After removing Emma from Finance Department:");
        financeDepartment.remove(employee4);
        System.out.println("Total salary: " + bossDepartment.getSalary());

        System.out.println(" ");
        System.out.println("New recruit! Welcome " + employee5.getName() + " to the " + recruitmentDepartment.getName()
                + " Department!");
        recruitmentDepartment.add(employee5);
        hrDepartment.add(recruitmentDepartment);

        System.out.println("Recruitment Hierarchy:");
        recruitmentDepartment.printHierarchy();
        System.out.println(" ");
        System.out.println("Total salary: " + bossDepartment.getSalary());
        System.out.println("Salary by Department:");
        System.out.println("HR: " + hrDepartment.getSalary());
        System.out.println("IT: " + itDepartment.getSalary());
        System.out.println("Finance: " + financeDepartment.getSalary());

        // Print the organizational structure in XML format
        String xmlContent = bossDepartment.toXml(0);
        System.out.println("\nOrganizational Structure in XML:");
        System.out.println(xmlContent);

        //writeToFile("organization_structure.xml", xmlContent);
    }

    private static void writeToFile(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("XML content written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        }
}
