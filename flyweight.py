class TipoLuchador:
    def __init__(self, nombre, estilo, poder):
        self.nombre = nombre
        self.estilo = estilo
        self.poder = poder
    
    def mostrar(self, vida, x, y):
        print(f"Mostrando {self.nombre} ({self.estilo}, Poder: {self.poder}) con vida {vida} en ({x}, {y})")

class FabricaLuchadores:
    _tipos = {}

    @staticmethod
    def obtener_tipo_luchador(nombre, estilo, poder):
        clave = (nombre, estilo, poder)
        if clave not in FabricaLuchadores._tipos:
            print(f"Creando nuevo tipo de luchador: {nombre} ({estilo}, Poder: {poder})")
            FabricaLuchadores._tipos[clave] = TipoLuchador(nombre, estilo, poder)
        return FabricaLuchadores._tipos[clave]

class Luchador:
    def __init__(self, tipo, vida, x, y):
        self.tipo = tipo
        self.vida = vida
        self.x = x
        self.y = y
    
    def dibujar(self):
        self.tipo.mostrar(self.vida, self.x, self.y)

# Creación de tipos de luchadores
ninja = FabricaLuchadores.obtener_tipo_luchador("Ryu", "Karate", "Hadouken")
samurai = FabricaLuchadores.obtener_tipo_luchador("Hanzo", "Kenjutsu", "Corte Relámpago")

# Creación de luchadores con diferentes posiciones y vida
luchadores = [
    Luchador(ninja, 100, 10, 20),
    Luchador(samurai, 120, 30, 40),
    Luchador(ninja, 90, 50, 60),
    Luchador(samurai, 110, 70, 80)
]

for luchador in luchadores:
    luchador.dibujar()
