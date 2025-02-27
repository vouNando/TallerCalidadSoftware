from abc import ABC, abstractmethod

class Button(ABC):
    @abstractmethod
    def render(self):
        pass

class Dialog(ABC):
    @abstractmethod
    def render(self):
        pass

class WindowsButton(Button):
    def render(self):
        print("Renderizando boton en Windows")

class MacOSButton(Button):
    def render(self):
        print("Renderizando boton en Mac")

class MacOSButton(Button):
    def render(self):
        print("Renderizando boton en Mac")
    
class UIFactory(ABC):
    @abstractmethod
    def create_button(self):
        pass
    
    def create_dialog(self):
        pass
