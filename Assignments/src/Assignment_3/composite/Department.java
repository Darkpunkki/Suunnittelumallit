package Assignment_3.composite;

import Assignment_3.component.Unit;

import java.util.ArrayList;
import java.util.List;

public class Department implements Unit {
    private String name;
    private List<Unit> units;

    public Department(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    @Override
    public void add(Unit unit) {
        units.add(unit);
    }

    @Override
    public void remove(Unit unit) {
        units.remove(unit);
    }

    @Override
    public int getSalary() {
        int totalSalary = 0;
        for (Unit unit : units) {
            totalSalary += unit.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Department: " + name;
    }

    @Override
    public String toXml(int indentationLevel) {
        String indent = "  ".repeat(indentationLevel);
        StringBuilder xml = new StringBuilder(indent + "<Department name=\"" + name + "\">\n");

        for (Unit unit : units) {
            xml.append(unit.toXml(indentationLevel + 1));
        }

        xml.append(indent + "</Department>\n");
        return xml.toString();
    }
}