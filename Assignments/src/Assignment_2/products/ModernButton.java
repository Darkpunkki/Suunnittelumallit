package Assignment_2.products;

import Assignment_2.abstract_factory.Button;

public class ModernButton extends Button {

    public ModernButton(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ " + this.text + " ]");
    }
}
