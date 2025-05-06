public class Operations {
    private int num1;
    private int num2;

    // Constructor
    public Operations(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Getter para num1
    public int getNum1() {
        return num1;
    }

    // Setter para num1
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    // Getter para num2
    public int getNum2() {
        return num2;
    }

    // Setter para num2
    public void setNum2(int num2) {
        this.num2 = num2;
    }
  // Método para sumar
    public int sumar() {
    return num1 + num2;
}

// Método para restar
public int restar() {
    return num1 - num2;
}

// Método para multiplicar
public int multiplicar() {
    return num1 * num2;
    }
}
