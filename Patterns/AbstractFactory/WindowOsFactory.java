package Patterns.AbstractFactory;

public class WindowOsFactory implements GuiFactory {
    @Override
    public Button getButton() {
        return new WindowButton();
    }

    @Override
    public Checkbox getCheckbox() {
        return new WindowCheckbox();
    }
}
