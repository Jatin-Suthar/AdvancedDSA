package AbstractFactoryPattern;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void click() {
        System.out.println("Checkbox button checked.");
    }

}
