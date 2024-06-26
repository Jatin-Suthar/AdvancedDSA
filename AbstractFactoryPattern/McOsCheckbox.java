package AbstractFactoryPattern;

public class McOsCheckbox implements Checkbox {

    @Override
    public void click() {
        System.out.println("McOs button checked.");
    }
    
}
