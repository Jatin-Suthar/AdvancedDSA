package Patterns.AbstractFactory;

public class Solution {

    public static Application configureApplication() {
        Application app;
        GuiFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")) {
            factory = new MacOsFactory();
        } else {
            factory = new WindowOsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.trigger();
    }

}
