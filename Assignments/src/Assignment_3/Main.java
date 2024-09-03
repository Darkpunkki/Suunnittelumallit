package Assignment_3;

import Assignment_3.component.Unit;
import Assignment_3.leaf.Employee;
import Assignment_3.composite.Department;

public class Main {
    public static void main(String[] args) {

        // Employees

        Unit employee1 = new Employee("John", 1000);
        Unit employee2 = new Employee("David", 1500);
        Unit employee3 = new Employee("Sophia", 2000);
        Unit employee4 = new Employee("Emma", 2500);
        Unit employee5 = new Employee("Olivia", 1800);


        // Departments

        Department hrDepartment = new Department("HR");
        Department itDepartment = new Department("IT");
        Department financeDepartment = new Department("Finance");
        Department bossDepartment = new Department("Head Office");

        // Sub-department

        Department recruitmentDepartment = new Department("Recruitment");


        hrDepartment.add(employee1);
        itDepartment.add(employee2);
        financeDepartment.add(employee3);
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
        System.out.println("New recruit! Welcome " + employee5 + " to the " + recruitmentDepartment);
        recruitmentDepartment.add(employee5);
        hrDepartment.add(recruitmentDepartment);
        System.out.println("Total salary: " + bossDepartment.getSalary());


        // Print the organizational structure in XML format
        System.out.println("\nOrganizational Structure in XML:");
        System.out.println(bossDepartment.toXml(0));

    }
}
