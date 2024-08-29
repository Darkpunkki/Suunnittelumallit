package Assignment_2.abstract_factory;

public interface UIFactory {
    Button createButton(String text);
    Checkbox createCheckbox(String text);
    TextField createTextField(String text);
}
