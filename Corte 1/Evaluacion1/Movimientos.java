import java.text.DecimalFormat;

/**
 * Clase Movimientos: Maneja las operaciones de depósito, retiro y consulta de saldo.
 */
public class Movimientos {

    private double saldo; // Saldo actual
    private DecimalFormat formato;

    /**
     * Constructor que inicializa el saldo en 0.
     */
    public Movimientos() {
        this.saldo = 0.0;
        this.formato = new DecimalFormat("$#.00");
    }

    /**
     * Deposita una cantidad al saldo.
     * 
     * @param monto Monto a depositar.
     */
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    /**
     * Retira una cantidad del saldo si hay suficiente.
     * 
     * @param monto Monto a retirar.
     * @return true si el retiro fue exitoso, false si no hay saldo suficiente.
     */
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    /**
     * Obtiene el saldo actual.
     * 
     * @return Saldo actual.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Devuelve el saldo formateado.
     * 
     * @return Saldo en formato de moneda.
     */
    public String getSaldoFormateado() {
        return formato.format(saldo);
    }
}
