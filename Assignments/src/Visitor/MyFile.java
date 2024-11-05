package Visitor;

public class MyFile implements FileSystemElement {
    private final String name;
    private final int size;

    public MyFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
