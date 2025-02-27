public class Main {
    public static void main(String[] args) {
        // Crear instancias de vehículos
        Vehiculo coche = new Coche();
        Vehiculo moto = new Moto();

        // Control básico para el coche
        ControlVehiculo controlCoche = new ControlVehiculo(coche);
        controlCoche.encender();
        controlCoche.apagar();

        // Control avanzado para la moto
        ControlAvanzado controlMoto = new ControlAvanzado(moto);
        controlMoto.encender();
        controlMoto.aumentarVelocidad();
        controlMoto.reducirVelocidad();
        controlMoto.apagar();
    }
}
