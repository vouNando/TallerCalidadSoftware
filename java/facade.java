// Clase que representa el Motor
class Motor {
    public void encender() {
        System.out.println("El motor está encendido.");
    }
    
    public void apagar() {
        System.out.println("El motor está apagado.");
    }
}

// Clase que representa las Luces
class Luces {
    public void encender() {
        System.out.println("Las luces están encendidas.");
    }
    
    public void apagar() {
        System.out.println("Las luces están apagadas.");
    }
}

// Clase que representa la Radio
class Radio {
    public void encender() {
        System.out.println("La radio está encendida.");
    }
    
    public void apagar() {
        System.out.println("La radio está apagada.");
    }
}

// Clase que representa el Automóvil y actúa como Facade
class Automovil {
    private Motor motor;
    private Luces luces;
    private Radio radio;
    
    public Automovil() {
        motor = new Motor();
        luces = new Luces();
        radio = new Radio();
    }
    
    public void modoViaje() {
        System.out.println("Activando modo viaje...");
        motor.encender();
        luces.encender();
        radio.encender();
    }
    
    public void modoEstacionado() {
        System.out.println("Activando modo estacionado...");
        motor.apagar();
        luces.apagar();
        radio.apagar();
    }
}

// Clase pública con el método main
public class facade {
    public static void main(String[] args) {
        Automovil auto = new Automovil();
        auto.modoViaje();
        System.out.println("---");
        auto.modoEstacionado();
    }
}
