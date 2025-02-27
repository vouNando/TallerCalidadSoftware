import copy
from abc import ABC, abstractmethod

class iPhone(ABC):
    @abstractmethod
    def clone(self):
        pass

    def __str__(self):
        return f"Model: {self.model}, Storage: {self.storage}GB, Color: {self.color}, iOS Version: {self.ios_version}"
    
class iPhoneModel(iPhone):
    def __init__(self, model, storage, color, ios_version):
        self.model = model
        self.storage = storage
        self.color = color
        self.ios_version = ios_version

    def clone(self):
        return copy.deepcopy(self)
        

    def __str__(self):
        return f"iPhone - Model: {self.model}, Storage: {self.storage}GB, Color: {self.color}, iOS Version: {self.ios_version}"

# Prototipo base de iPhone
iphone_prototype = iPhoneModel("iPhone 14", 128, "Silver", "iOS 16")

# Creación de nuevos iPhones a partir del prototipo
iphone1 = iphone_prototype.clone()
iphone1.model = "iPhone 15"
iphone1.color = "Gold"
iphone1.ios_version = "iOS 17"

iphone2 = iphone_prototype.clone()
iphone2.model = "iPhone 15 Pro"
iphone2.storage = 256
iphone2.color = "Titanium"

iphone3 = iphone_prototype.clone()
iphone3.model = "iPhone SE"
iphone3.storage = 64
iphone3.color = "Red"
iphone3.ios_version = "iOS 16"

# Imprimir resultados
print(iphone1)
print(iphone2)
print(iphone3)
