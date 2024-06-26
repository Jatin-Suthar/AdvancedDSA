package AbstractFactoryPattern;

public class McOsFactory implements GuiFactory {

    @Override
    public McOsButton createButton() {
        return new McOsButton();
    }

    @Override
    public McOsCheckbox createCheckbox() {
        return new McOsCheckbox();
    }

}
