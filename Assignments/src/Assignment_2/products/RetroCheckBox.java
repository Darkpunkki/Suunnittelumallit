package Assignment_2.products;

import Assignment_2.abstract_factory.Checkbox;

public class RetroCheckBox extends Checkbox {



    public RetroCheckBox(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[Retro] [X] " + this.text);
    }
}
