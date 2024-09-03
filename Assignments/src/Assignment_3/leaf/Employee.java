package Assignment_3.leaf;

import Assignment_3.component.Unit;

public class Employee implements Unit {
    private final String name;
    private final int salary;
    private Unit parent;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(Unit unit) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }

    @Override
    public void remove(Unit unit) {
        throw new UnsupportedOperationException("Cannot remove from an employee");
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String toXml(int indentationLevel) {
        String indent = "  ".repeat(indentationLevel);
        return indent + "<Employee name=\"" + name + "\" salary=\"" + salary + "\"/>\n";
    }

    @Override
    public void setParent(Unit parent) {
        this.parent = parent;
    }

    @Override
    public Unit getParent() {
        return this.parent;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
