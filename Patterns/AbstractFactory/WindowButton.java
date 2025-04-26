package Patterns.AbstractFactory;

public class WindowButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicked WindowOs Button...");
    }
}
