from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, subject):
        pass

class CuentaBancaria:
    def __init__(self, numero_cuenta):
        self.numero_cuenta = numero_cuenta
        self.balance = 0
        self.observers = []
    
    def add_observer(self, observer):
        self.observers.append(observer)
    
    def remove_observer(self, observer):
        self.observers.remove(observer)
    
    def notify_observers(self):
        for observer in self.observers:
            observer.update(self)
    
    def depositar(self, monto):
        self.balance += monto
        self.notify_observers()
        print(f"Depósito de {monto} realizado en la cuenta {self.numero_cuenta}. Balance actual: {self.balance}")
    
    def retirar(self, monto):
        if self.balance >= monto:
            self.balance -= monto
            self.notify_observers()
            print(f"Retiro de {monto} realizado de la cuenta {self.numero_cuenta}. Balance actual: {self.balance}")
        else:
            print("Fondos insuficientes")

class Cliente(Observer):
    def __init__(self, nombre):
        self.nombre = nombre
    
    def update(self, subject):
        print(f"Notificación para {self.nombre}: El balance de la cuenta {subject.numero_cuenta} ha cambiado. Nuevo balance: {subject.balance}")

# Crear cuenta bancaria y clientes
cuenta = CuentaBancaria("12345678")
cliente1 = Cliente("Carlos")
cliente2 = Cliente("Ana")

cuenta.add_observer(cliente1)
cuenta.add_observer(cliente2)

# Realizar operaciones en la cuenta
cuenta.depositar(500)
cuenta.retirar(200)
cuenta.retirar(400)
