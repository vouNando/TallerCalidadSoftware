import java.util.ArrayList;
import java.util.List;

// Interfaz Prototype
interface iPhone extends Cloneable {
    iPhone clone();
    void mostrar();
}

// Clase concreta que implementa el prototipo
class iPhoneModel implements iPhone {
    private String model;
    private int storage;
    private String color;
    private String iosVersion;

    public iPhoneModel(String model, int storage, String color, String iosVersion) {
        this.model = model;
        this.storage = storage;
        this.color = color;
        this.iosVersion = iosVersion;
    }

    @Override
    public iPhone clone() {
        return new iPhoneModel(model, storage, color, iosVersion);
    }

    @Override
    public void mostrar() {
        System.out.println("iPhone - Model: " + model + ", Storage: " + storage + "GB, Color: " + color + ", iOS Version: " + iosVersion);
    }
}

// Clase principal
public class prototype {
    public static void main(String[] args) {
        // Prototipo base de iPhone
        iPhoneModel iphonePrototype = new iPhoneModel("iPhone 14", 128, "Silver", "iOS 16");

        // Creación de nuevos iPhones a partir del prototipo
        iPhone iphone1 = iphonePrototype.clone();
        ((iPhoneModel) iphone1).mostrar();

        iPhone iphone2 = iphonePrototype.clone();
        ((iPhoneModel) iphone2).mostrar();

        iPhone iphone3 = iphonePrototype.clone();
        ((iPhoneModel) iphone3).mostrar();
    }
}
