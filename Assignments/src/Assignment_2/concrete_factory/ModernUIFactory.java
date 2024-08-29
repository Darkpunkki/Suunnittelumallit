package Assignment_2.concrete_factory;

import Assignment_2.abstract_factory.Button;
import Assignment_2.abstract_factory.Checkbox;
import Assignment_2.abstract_factory.TextField;
import Assignment_2.abstract_factory.UIFactory;
import Assignment_2.products.ModernButton;
import Assignment_2.products.ModernTextField;
import Assignment_2.products.ModernCheckBox;

public class ModernUIFactory implements UIFactory {
    @Override
    public Button createButton(String text) {
        return new ModernButton(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new ModernCheckBox(text);
    }


    @Override
    public TextField createTextField(String text) {
        return new ModernTextField(text);
    }
}
