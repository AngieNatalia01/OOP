import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el primer número: ");
            int numero1 = scanner.nextInt();

            System.out.print("Ingrese el segundo número: ");
            int numero2 = scanner.nextInt();

            Operations operacion = new Operations(numero1, numero2);

            // Mostramos los resultados de las operaciones
            System.out.println("Suma: " + operacion.sumar());
            System.out.println("Resta: " + operacion.restar());
            System.out.println("Multiplicación: " + operacion.multiplicar());
        }
    }
}



