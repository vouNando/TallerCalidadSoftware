// Definimos la interfaz Button
interface Button {
    void render();
}

// Definimos la interfaz Dialog
interface Dialog {
    void render();
}

// Implementación de Button para Windows
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando boton en Windows");
    }
}

// Implementación de Button para MacOS
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando boton en Mac");
    }
}

// UIFactory abstracta
abstract class UIFactory {
    public abstract Button createButton();
    public Dialog createDialog() {
        return null; // Opcional, puede ser implementado en clases concretas
    }
}

// Implementación concreta de UIFactory para crear botones para Windows
class WindowsUIFactory extends UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

// Implementación concreta de UIFactory para crear botones para Mac
class MacOSUIFactory extends UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}

// Clase principal para probar el patrón Abstract Factory
public class abstract_factory {
    public static void main(String[] args) {
        UIFactory windowsFactory = new WindowsUIFactory();
        Button windowsButton = windowsFactory.createButton();
        windowsButton.render();

        UIFactory macFactory = new MacOSUIFactory();
        Button macButton = macFactory.createButton();
        macButton.render();
    }
}
