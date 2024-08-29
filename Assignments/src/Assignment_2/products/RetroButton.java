package Assignment_2.products;

import Assignment_2.abstract_factory.Button;

public class RetroButton extends Button {


    public RetroButton(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[== " + this.text + " ==]");
    }
}