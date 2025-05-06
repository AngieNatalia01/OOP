import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Solicitar al usuario los números
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar al usuario los números
            System.out.print("Ingrese el primer número: ");
            int numero1 = scanner.nextInt();
            System.out.print("Ingrese el segundo número: ");
            int numero2 = scanner.nextInt();
            // Crear una instancia de Operations
            Operations operacion = new Operations(numero1, numero2);
            // Mostrar resultados utilizando los métodos
            System.out.println("Suma: " + operacion.sumar());
            System.out.println("Resta: " + operacion.restar());
            System.out.println("Multiplicación: " + operacion.multiplicar());
        }
    }
}
