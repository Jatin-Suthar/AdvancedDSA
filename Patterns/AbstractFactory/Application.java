package Patterns.AbstractFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;
    public Application(GuiFactory factory) {
        this.button = factory.getButton();
        this.checkbox = factory.getCheckbox();
    }
    public void trigger() {
        this.button.click();
        this.checkbox.check();
    }
}
