import java.util.ArrayList;
import java.util.List;

// Interfaz Observer
interface Observer {
    void update(CuentaBancaria cuenta);
}

// Clase CuentaBancaria (Subject)
class CuentaBancaria {
    private String numeroCuenta;
    private double balance;
    private List<Observer> observers;

    public CuentaBancaria(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.balance = 0;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void depositar(double monto) {
        balance += monto;
        notifyObservers();
        System.out.println("Depósito de " + monto + " realizado en la cuenta " + numeroCuenta + ". Balance actual: " + balance);
    }

    public void retirar(double monto) {
        if (balance >= monto) {
            balance -= monto;
            notifyObservers();
            System.out.println("Retiro de " + monto + " realizado de la cuenta " + numeroCuenta + ". Balance actual: " + balance);
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getBalance() {
        return balance;
    }
}

// Clase Cliente que actúa como Observer
class Cliente implements Observer {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(CuentaBancaria cuenta) {
        System.out.println("Notificación para " + nombre + ": El balance de la cuenta " + cuenta.getNumeroCuenta() + " ha cambiado. Nuevo balance: " + cuenta.getBalance());
    }
}

// Clase principal (Observer.java)
public class numeroCuenta {
    public static void main(String[] args) {
        // Crear cuenta bancaria y clientes
        CuentaBancaria cuenta = new CuentaBancaria("12345678");
        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Ana");

        cuenta.addObserver(cliente1);
        cuenta.addObserver(cliente2);

        // Realizar operaciones en la cuenta
        cuenta.depositar(500);
        cuenta.retirar(200);
        cuenta.retirar(400);
    }
}
