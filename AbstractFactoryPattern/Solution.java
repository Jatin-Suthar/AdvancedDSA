package AbstractFactoryPattern;

public class Solution {

    public static void main(String[] args) {
        Application application;
        GuiFactory guiFactory;
        guiFactory = new WindowsFactory();
        application = new Application(guiFactory);
        application.click();
        guiFactory = new McOsFactory();
        application = new Application(guiFactory);
        application.click();
    }

}
