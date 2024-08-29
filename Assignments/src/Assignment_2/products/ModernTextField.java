package Assignment_2.products;

import Assignment_2.abstract_factory.TextField;

public class ModernTextField extends TextField {


    public ModernTextField(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("───────────────");
        System.out.println(this.text);
        System.out.println("───────────────");
    }
}
