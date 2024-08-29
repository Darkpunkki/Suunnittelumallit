package Assignment_2.main;

import Assignment_2.abstract_factory.Button;
import Assignment_2.abstract_factory.Checkbox;
import Assignment_2.abstract_factory.TextField;
import Assignment_2.abstract_factory.UIFactory;
import Assignment_2.concrete_factory.ModernUIFactory;
import Assignment_2.concrete_factory.RetroUIFactory;

public class App {
    public static void main(String[] args) {
        UIFactory modernFactory = new ModernUIFactory();
        UIFactory retroFactory = new RetroUIFactory();

        Button modernButton = modernFactory.createButton("OK");
        TextField modernTextField = modernFactory.createTextField("Enter your name");
        Checkbox modernCheckbox = modernFactory.createCheckbox("I agree to the terms and conditions");

        Button retroButton = retroFactory.createButton("OK");
        TextField retroTextField = retroFactory.createTextField("Enter your name");
        Checkbox retroCheckbox = retroFactory.createCheckbox("I agree to the terms and conditions");

        // Initial content
        displayAll(modernButton, modernTextField, modernCheckbox);
        System.out.println(" ");
        displayAll(retroButton, retroTextField, retroCheckbox);

        System.out.println(" ");
        System.out.println("**************************");
        System.out.println(" ");

        // Change the text
        modernButton.setText("Not ok");
        modernTextField.setText("Enter your email");
        modernCheckbox.setText("I do not agree to the terms and conditions");

        retroButton.setText("Not ok");
        retroTextField.setText("Enter your email");
        retroCheckbox.setText("I do not agree to the terms and conditions");

        // Display the updated content
        displayAll(modernButton, modernTextField, modernCheckbox);
        System.out.println(" ");
        displayAll(retroButton, retroTextField, retroCheckbox);
    }

    public static void displayAll(Button button, TextField textField, Checkbox checkbox) {
        button.display();
        textField.display();
        checkbox.display();
    }
}
