from collections.abc import Iterator, Iterable

class Cancion:
    def __init__(self, titulo, artista):
        self.titulo = titulo
        self.artista = artista

    def __str__(self):
        return f'"{self.titulo}" de {self.artista}'

class ListaReproduccionIterator(Iterator):
    def __init__(self, canciones):
        self.canciones = canciones
        self.indice = 0

    def __next__(self):
        if self.indice >= len(self.canciones):
            raise StopIteration
        cancion = self.canciones[self.indice]
        self.indice += 1
        return cancion

class ListaReproduccion(Iterable):
    def __init__(self):
        self.canciones = []

    def agregar_cancion(self, cancion):
        self.canciones.append(cancion)
    
    def __iter__(self):
        return ListaReproduccionIterator(self.canciones)

# Crear lista de reproducción y agregar canciones
playlist = ListaReproduccion()

playlist.agregar_cancion(Cancion("Bohemian Rhapsody", "Queen"))
playlist.agregar_cancion(Cancion("Smells Like Teen Spirit", "Nirvana"))
playlist.agregar_cancion(Cancion("Hotel California", "Eagles"))

# Iterar sobre la lista de reproducción
for cancion in playlist:
    print(cancion)
