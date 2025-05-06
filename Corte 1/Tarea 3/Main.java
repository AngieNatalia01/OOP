import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        // ventana principal para la calculadora
        JFrame frame = new JFrame("Calculadora"); 
        frame.setSize(500, 100); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new FlowLayout()); 

        // botones de operaciones (Suma, Resta, Multiplicación)
        JButton sumButton = new JButton("Suma");
        JButton subtractButton = new JButton("Resta");
        JButton multiplyButton = new JButton("Multiplicación");

        //etiqueta donde se mostrará el resultado
        JLabel resultLabel = new JLabel("Resultado: ");

        // Acción que se realiza cuando se hace elegir el botón de la operacion 
        sumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation("Suma", resultLabel);
            }
        });

        // botón de Resta
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation("Resta", resultLabel);
            }
        });

        // Multiplicación
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation("Multiplicación", resultLabel);
            }
        });

        // Añadir los botones y la etiqueta de resultado a la ventana
        frame.add(sumButton); 
        frame.add(subtractButton); 
        frame.add(multiplyButton); 
        frame.add(resultLabel); 

        frame.setVisible(true); 
    }

    // Método para realizar la operación matemática
    public static void performOperation(String operationType, JLabel resultLabel) {
        String input1 = JOptionPane.showInputDialog("Ingrese el primer número:");
        String input2 = JOptionPane.showInputDialog("Ingrese el segundo número:");

        try {
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            // Creamos un objeto de la clase Operations con los dos números
            Operations op = new Operations(num1, num2);
            int result = 0;

            switch (operationType) {
                case "Suma":
                    result = op.sumar();
                    break;
                case "Resta":
                    result = op.restar();
                    break;
                case "Multiplicación":
                    result = op.multiplicar();
                    break;
            }

            // Mostrar el resultado en la etiqueta
            resultLabel.setText("Resultado: " + result);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Por favor ingresa números válidos.");
        }
    }
}




