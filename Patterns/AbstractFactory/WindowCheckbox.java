package Patterns.AbstractFactory;

public class WindowCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Checking WindowOs checkbox...");
    }
}
