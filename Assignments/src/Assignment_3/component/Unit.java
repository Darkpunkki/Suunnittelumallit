package Assignment_3.component;

public interface Unit {
    void add(Unit unit);    // Add a child unit
    void remove(Unit unit); // Remove a child unit
    int getSalary();
    String toXml(int indentationLevel);
    void setParent(Unit parent);
    Unit getParent();
    String getName();
}
