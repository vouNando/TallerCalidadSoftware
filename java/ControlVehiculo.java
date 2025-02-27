public class ControlVehiculo {
    protected Vehiculo vehiculo;

    public ControlVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void encender() {
        vehiculo.encender();
    }

    public void apagar() {
        vehiculo.apagar();
    }
}
