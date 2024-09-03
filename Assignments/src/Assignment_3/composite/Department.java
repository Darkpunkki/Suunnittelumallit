package Assignment_3.composite;

import Assignment_3.component.Unit;

import java.util.ArrayList;
import java.util.List;

public class Department implements Unit {
    private final String name;
    private final List<Unit> units;
    private Unit parent;

    public Department(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    @Override
    public void add(Unit unit) {
        units.add(unit);
        unit.setParent(this);
    }

    @Override
    public void remove(Unit unit) {
        units.remove(unit);
        unit.setParent(null);
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
    public String toXml(int indentationLevel) {
        String indent = "  ".repeat(indentationLevel);
        StringBuilder xml = new StringBuilder(indent + "<Department name=\"" + name + "\">\n");

        for (Unit unit : units) {
            xml.append(unit.toXml(indentationLevel + 1));
        }

        xml.append(indent).append("</Department>\n");
        return xml.toString();
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

    public void printHierarchy() {
        StringBuilder hierarchy = new StringBuilder(this.getName());
        Unit currentParent = this.getParent();
        while (currentParent != null) {
            hierarchy.insert(0, currentParent.getName() + " -> ");
            currentParent = currentParent.getParent();
        }
        System.out.println(hierarchy);
    }
}