package Patterns.AbstractFactory;

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicked MacOs Button...");
    }
}
