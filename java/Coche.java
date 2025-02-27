public class Coche extends Vehiculo {
    private boolean encendido = false;
    private int velocidad = 0;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Coche encendido");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Coche apagado");
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        System.out.println("Velocidad del coche: " + this.velocidad + " km/h");
    }

    @Override
    public int getVelocidad() {
        return velocidad;  // Implementación de getVelocidad
    }
}
