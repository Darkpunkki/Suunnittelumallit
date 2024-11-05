package Visitor;


public class StructurePrinterVisitor implements FileSystemVisitor {
    private int depth = 0;

    private String getIndentation() {
        return "    ".repeat(depth);
    }

    @Override
    public void visit(MyFile file) {
        System.out.println(getIndentation() + "File: " + file.getName() + " (" + file.getSize() + " MB)");
    }

    @Override
    public void visit (Directory directory) {
        System.out.println(getIndentation() + "Directory: " + directory.getName());
        depth++;
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
        depth--;
    }
}
