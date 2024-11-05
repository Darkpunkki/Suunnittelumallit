package Visitor;

public class Main {
    public static void main(String[] args) {
        // Create files & directories
        MyFile file1 = new MyFile("document.txt", 1);
        MyFile file2 = new MyFile("presentation.ppt", 31);
        MyFile file3 = new MyFile("image.jpg", 17);
        MyFile file4 = new MyFile("notes.txt", 2);

        Directory rootDir = new Directory("root");
        Directory subDir1 = new Directory("Documents");
        Directory subDir2 = new Directory("Images");
        Directory subDir3 = new Directory("Presentations");

        // Build the file system structure
        subDir1.addElement(file1);
        subDir1.addElement(file4);

        subDir2.addElement(file3);

        subDir3.addElement(file2);

        rootDir.addElement(subDir1);
        rootDir.addElement(subDir2);
        rootDir.addElement(subDir3);


        // Apply SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        rootDir.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getSize() + " MB \n");

        // Apply SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        rootDir.accept(searchVisitor);
        System.out.println("Files matching '.txt' pattern:");
        for (MyFile file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName());
        }
        System.out.println(" ");

        // Apply structureVisitor
        System.out.println("File system structure:");
        StructurePrinterVisitor structurePrinterVisitor = new StructurePrinterVisitor();
        rootDir.accept(structurePrinterVisitor);

    }
}
