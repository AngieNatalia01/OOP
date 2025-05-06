// Clase que realiza las operaciones matemáticas
public class Operations {
    private int num1;
    private int num2;

    // Constructor para inicializar los números
    public Operations(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Método para realizar la suma
    public int sumar() {
        return num1 + num2;
    }

    // Método para realizar la resta
    public int restar() {
        return num1 - num2;
    }

    // Método para realizar la multiplicación
    public int multiplicar() {
        return num1 * num2;
    }
}
