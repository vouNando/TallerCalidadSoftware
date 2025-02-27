class Motor:
    def encender(self):
        print("El motor está encendido.")

    def apagar(self):
        print("El motor está apagado.")

class Luces:
    def encender(self):
        print("Las luces están encendidas.")

    def apagar(self):
        print("Las luces están apagadas.")

class Radio:
    def encender(self):
        print("La radio está encendida.")

    def apagar(self):
        print("La radio está apagada.")

class Automovil:
    def __init__(self):
        self.motor = Motor()
        self.luces = Luces()
        self.radio = Radio()

    def modo_viaje(self):
        print("Activando modo viaje...")
        self.motor.encender()
        self.luces.encender()
        self.radio.encender()

    def modo_estacionado(self):
        print("Activando modo estacionado...")
        self.motor.apagar()
        self.luces.apagar()
        self.radio.apagar()

if __name__ == "__main__":
    auto = Automovil()
    auto.modo_viaje()
    print("---")
    auto.modo_estacionado()
