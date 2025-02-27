// Clase Motor
class Motor {
    void encender() {
        System.out.println("El motor está encendido.");
    }

    void apagar() {
        System.out.println("El motor está apagado.");
    }
}

// Clase Luces
class Luces {
    void encender() {
        System.out.println("Las luces están encendidas.");
    }

    void apagar() {
        System.out.println("Las luces están apagadas.");
    }
}

// Clase Radio
class Radio {
    void encender() {
        System.out.println("La radio está encendida.");
    }

    void apagar() {
        System.out.println("La radio está apagada.");
    }
}

// Clase Automovil
class Automovil {
    private Motor motor;
    private Luces luces;
    private Radio radio;

    public Automovil() {
        this.motor = new Motor();
        this.luces = new Luces();
        this.radio = new Radio();
    }

    void modoViaje() {
        System.out.println("Activando modo viaje...");
        motor.encender();
        luces.encender();
        radio.encender();
    }

    void modoEstacionado() {
        System.out.println("Activando modo estacionado...");
        motor.apagar();
        luces.apagar();
        radio.apagar();
    }
}

// Clase principal con el método main
public class facade {
    public static void main(String[] args) {
        Automovil auto = new Automovil();
        auto.modoViaje();
        System.out.println("---");
        auto.modoEstacionado();
    }
}
