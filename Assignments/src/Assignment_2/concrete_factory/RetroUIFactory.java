package Assignment_2.concrete_factory;

import Assignment_2.abstract_factory.*;
import Assignment_2.products.*;

public class RetroUIFactory implements UIFactory {
    @Override
    public Button createButton(String text) {
        return new RetroButton(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new RetroCheckBox(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new RetroTextField(text);
    }
}