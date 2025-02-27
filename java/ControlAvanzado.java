public class ControlAvanzado extends ControlVehiculo {

    public ControlAvanzado(Vehiculo vehiculo) {
        super(vehiculo);
    }

    public void aumentarVelocidad() {
        int nuevaVelocidad = vehiculo.getVelocidad() + 10;
        vehiculo.setVelocidad(nuevaVelocidad);
    }

    public void reducirVelocidad() {
        int nuevaVelocidad = vehiculo.getVelocidad() - 10;
        vehiculo.setVelocidad(nuevaVelocidad);
    }
}
