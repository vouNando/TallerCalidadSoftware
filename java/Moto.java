public class Moto extends Vehiculo {
    private boolean encendido = false;
    private int velocidad = 0;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Moto encendida");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Moto apagada");
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        System.out.println("Velocidad de la moto: " + this.velocidad + " km/h");
    }

    @Override
    public int getVelocidad() {
        return velocidad;  // Implementación de getVelocidad
    }
}
