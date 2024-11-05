package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public void visit(MyFile file) {
        size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}
