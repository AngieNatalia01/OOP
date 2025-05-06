import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 1));
        frame.getContentPane().setBackground(new Color(255, 192, 204)); // Rosado pastel

        // Campos de texto
        JTextField num1Field = new JTextField();
        JTextField num2Field = new JTextField();

        // Etiqueta para mostrar el resultado
        JLabel resultLabel = new JLabel("Resultado:", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(new Color(128, 0, 128)); // Morado

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 182, 193)); // Rosado claro

        JButton sumButton = new JButton("Sumar");
        JButton restButton = new JButton("Restar");
        JButton multButton = new JButton("Multiplicar");

        // Agregar botones al panel
        buttonPanel.add(sumButton);
        buttonPanel.add(restButton);
        buttonPanel.add(multButton);

        // Agregar elementos al frame
        frame.add(new JLabel("Ingrese el primer número:", JLabel.CENTER));
        frame.add(num1Field);
        frame.add(new JLabel("Ingrese el segundo número:", JLabel.CENTER));
        frame.add(num2Field);
        frame.add(buttonPanel);
        frame.add(resultLabel);

        // Acción del botón SUMAR
        sumButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());

                // Creamos objeto y usamos setters
                Operations operacion = new Operations(0, 0);
                operacion.setNum1(num1);
                operacion.setNum2(num2);

                // Usamos getters para mostrar qué números se sumaron
                int resultado = operacion.sumar();
                resultLabel.setText("Suma: " + operacion.getNum1() + " + " + operacion.getNum2() + " = " + resultado);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, ingresa números válidos.");
            }
        });

        // Acción del botón RESTAR
        restButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());

                Operations operacion = new Operations(0, 0);
                operacion.setNum1(num1);
                operacion.setNum2(num2);

                int resultado = operacion.restar();
                resultLabel.setText("Resta: " + operacion.getNum1() + " - " + operacion.getNum2() + " = " + resultado);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, ingresa números válidos.");
            }
        });

        // Acción del botón MULTIPLICAR
        multButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());

                Operations operacion = new Operations(0, 0);
                operacion.setNum1(num1);
                operacion.setNum2(num2);

                int resultado = operacion.multiplicar();
                resultLabel.setText("Multiplicación: " + operacion.getNum1() + " x " + operacion.getNum2() + " = " + resultado);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, ingresa números válidos.");
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}




