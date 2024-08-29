package Assignment_2.products;

import Assignment_2.abstract_factory.Checkbox;

public class ModernCheckBox extends Checkbox {


    public ModernCheckBox(String text) {
       super(text);
    }

    @Override
    public void display() {
        System.out.println("[Modern] [ ] " + this.text);
    }
}
