package Patterns.AbstractFactory;

public class MacOsFactory implements GuiFactory {
    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public Checkbox getCheckbox() {
        return new MacCheckbox();
    }
}
