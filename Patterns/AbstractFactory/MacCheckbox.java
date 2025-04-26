package Patterns.AbstractFactory;

public class MacCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Checked MacOs checkbox...");
    }
}
