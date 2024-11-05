package Visitor;


import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private final String searchPattern;
    private final List<MyFile> foundFiles = new ArrayList<>();

    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    public List<MyFile> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public void visit(MyFile file) {
        if (file.getName().endsWith(searchPattern) && !foundFiles.contains(file)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}
