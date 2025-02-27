from abc import ABC, abstractmethod

class Vehiculo(ABC):
    @abstractmethod
    def encender(self):
        pass

    @abstractmethod
    def apagar(self):
        pass

    @abstractmethod
    def set_velocidad(self, velocidad):
        pass

class Coche(Vehiculo):
    def __init__(self):
        self.encendido = False
        self.velocidad = 0

    def encender(self):
        self.encendido = True
        print("Coche encendido")

    def apagar(self):
        self.encendido = False
        print("Coche apagado")

    def set_velocidad(self, velocidad):
        self.velocidad = velocidad
        print(f"Velocidad del coche: {self.velocidad} km/h")
    
class Moto(Vehiculo):
    def __init__(self):
        self.encendido = False
        self.velocidad = 0
    
    def encender(self):
        self.encendido = True
        print("Moto encendida")

    def apagar(self):
        self.encendido = False
        print("Moto apagada")

    def set_velocidad(self, velocidad):
        self.velocidad = velocidad
        print(f"Velocidad de la moto: {self.velocidad} km/h")

class ControlVehiculo:
    def __init__(self, vehiculo):
        self.vehiculo = vehiculo
    
    def encender(self):
        self.vehiculo.encender()

    def apagar(self):
        self.vehiculo.apagar()

class ControlAvanzado(ControlVehiculo):
    def aumentar_velocidad(self):
        self.vehiculo.set_velocidad(self.vehiculo.velocidad + 10)

    def reducir_velocidad(self):
        self.vehiculo.set_velocidad(self.vehiculo.velocidad - 10)

coche = Coche()
moto = Moto()

control_coche = ControlVehiculo(coche)
control_coche.encender()
control_coche.apagar()

control_moto = ControlAvanzado(moto)
control_moto.encender()
control_moto.aumentar_velocidad()
control_moto.reducir_velocidad()
control_moto.apagar()
