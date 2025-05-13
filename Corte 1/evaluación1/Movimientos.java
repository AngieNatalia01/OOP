import java.util.ArrayList;

public class Movimientos {

    // Atributos
    private double saldo;
    private ArrayList<String> historial;

    // Constructor sin parámetros (inicializa en 0.0)
    public Movimientos() {
        this.saldo = 0.0;
        this.historial = new ArrayList<>();
    }

    // Constructor con parámetros
    public Movimientos(double saldoInicial) {
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();
        agregarAHistorial("Cuenta creada con saldo inicial: $" + saldoInicial);
    }

    // Getter para saldo
    public double getSaldo() {
        return saldo;
    }

    // Setter para saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Getter para historial
    public ArrayList<String> getHistorial() {
        return historial;
    }

    // Setter para historial
    public void setHistorial(ArrayList<String> historial) {
        this.historial = historial;
    }

    // Método para depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            agregarAHistorial("Depósito: $" + monto);
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0.");
        }
    }

    // Método para retirar
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            agregarAHistorial("Retiro: $" + monto);
            return true;
        } else {
            System.out.println("Fondos insuficientes o monto no válido.");
            return false;
        }
    }

    // Método para consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Método para agregar transacciones al historial
    private void agregarAHistorial(String transaccion) {
        historial.add(transaccion);
    }

    // Método para mostrar historial
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            System.out.println("Historial de transacciones:");
            for (String transaccion : historial) {
                System.out.println(transaccion);
            }
        }
    }
}

