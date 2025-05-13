import javax.swing.*; // Importa todas las clases necesarias para crear la interfaz gráfica
import java.awt.*; // Importa clases para gestionar el diseño y disposición de los componentes
import java.awt.event.ActionEvent; // Importa la clase para manejar eventos de acción (clics de botones)
import java.awt.event.ActionListener; // Interfaz para escuchar eventos de acción
import java.util.ArrayList; // Importa la clase ArrayList para manejar el historial de movimientos
import java.text.DecimalFormat; // Importa DecimalFormat para formatear los montos

/**
 * Clase InterfazCajero: Implementa la interfaz gráfica del cajero automático.
 * Permite al usuario realizar depósitos, retiros, consultar saldo y ver historial de movimientos.
 */
public class Interfaz extends JFrame {

    // Componentes principales de la interfaz
    private JPanel panelInicial, panelOpciones, panelHistorial;
    private JButton btnDepositar, btnRetirar, btnConsultarSaldo, btnVerHistorial;
    private JButton btnMonto50, btnMonto100, btnMonto200, btnOtro, btnConfirmar, btnVolver;
    private JTextField txtMonto;
    private JLabel lblMensaje, lblSaldo;
    private JTextArea txtHistorial;

    // Variables de lógica del cajero
    private double saldo; // Saldo actual
    private boolean esRetiro; // Indica si la operación es un retiro
    private ArrayList<String> historial; // Lista para almacenar los movimientos
    private DecimalFormat formato; // Formateador para mostrar los montos

    /**
     * Constructor de la interfaz del cajero.
     * Inicializa todos los componentes y configura la ventana principal.
     */
    public Interfaz() {
        setTitle("Cajero Automático");
        setSize(400, 400);
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana
        setLayout(new CardLayout()); // Usa un diseño de tarjetas para cambiar entre pantallas

        saldo = 0.0;
        esRetiro = false;
        historial = new ArrayList<>();
        formato = new DecimalFormat("$#.00"); // Formato para los montos

        // Inicializa los paneles
        iniciarPanelInicial();
        iniciarPanelOpciones();
        iniciarPanelHistorial();

        // Añade los paneles al contenedor principal
        add(panelInicial, "panelInicial");
        add(panelOpciones, "panelOpciones");
        add(panelHistorial, "panelHistorial");

        // Muestra el panel inicial al iniciar
        mostrarPanel("panelInicial");
    }

    /**
     * Inicializa el panel inicial con las opciones principales.
     */
    private void iniciarPanelInicial() {
        panelInicial = new JPanel(new GridLayout(5, 1, 10, 10));

        btnDepositar = new JButton("Depositar");
        btnRetirar = new JButton("Retirar");
        btnConsultarSaldo = new JButton("Consultar Saldo");
        btnVerHistorial = new JButton("Ver Historial");
        lblSaldo = new JLabel("Saldo: $0.00", JLabel.CENTER);

        panelInicial.add(btnDepositar);
        panelInicial.add(btnRetirar);
        panelInicial.add(btnConsultarSaldo);
        panelInicial.add(btnVerHistorial);
        panelInicial.add(lblSaldo);

        btnDepositar.addActionListener(e -> {
            esRetiro = false;
            mostrarPanel("panelOpciones");
        });

        btnRetirar.addActionListener(e -> {
            esRetiro = true;
            mostrarPanel("panelOpciones");
        });

        btnConsultarSaldo.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Saldo actual: " + formato.format(saldo));
        });

        btnVerHistorial.addActionListener(e -> mostrarPanel("panelHistorial"));
    }

    /**
     * Inicializa el panel de opciones para seleccionar montos.
     */
    private void iniciarPanelOpciones() {
        panelOpciones = new JPanel(new GridLayout(6, 1, 10, 10));

        btnMonto50 = new JButton("$50");
        btnMonto100 = new JButton("$100");
        btnMonto200 = new JButton("$200");
        btnOtro = new JButton("Otro");
        txtMonto = new JTextField();
        lblMensaje = new JLabel("Selecciona un monto:", JLabel.CENTER);
        btnConfirmar = new JButton("Confirmar");

        panelOpciones.add(lblMensaje);
        panelOpciones.add(btnMonto50);
        panelOpciones.add(btnMonto100);
        panelOpciones.add(btnMonto200);
        panelOpciones.add(btnOtro);
        panelOpciones.add(btnConfirmar);

        btnMonto50.addActionListener(e -> realizarOperacion(50));
        btnMonto100.addActionListener(e -> realizarOperacion(100));
        btnMonto200.addActionListener(e -> realizarOperacion(200));

        btnOtro.addActionListener(e -> panelOpciones.add(txtMonto));

        btnConfirmar.addActionListener(e -> {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                realizarOperacion(monto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Monto inválido.");
            }
        });
    }

    /**
     * Inicializa el panel del historial de movimientos.
     */
    private void iniciarPanelHistorial() {
        panelHistorial = new JPanel(new BorderLayout(10, 10));

        txtHistorial = new JTextArea();
        txtHistorial.setEditable(false);
        panelHistorial.add(new JScrollPane(txtHistorial), BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mostrarPanel("panelInicial"));
        panelHistorial.add(btnVolver, BorderLayout.SOUTH);
    }

    /**
     * Realiza la operación de depósito o retiro.
     */
    private void realizarOperacion(double monto) {
        if (monto <= 0) {
            JOptionPane.showMessageDialog(this, "El monto debe ser mayor a cero.");
        } else if (esRetiro && monto > saldo) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
        } else {
            saldo += esRetiro ? -monto : monto;
            String operacion = esRetiro ? "Retiro: -" : "Depósito: +";
            historial.add(operacion + formato.format(monto));
            lblSaldo.setText("Saldo: " + formato.format(saldo));
        }
        txtMonto.setText("");
        actualizarHistorial();
        mostrarPanel("panelInicial");
    }

    /**
     * Actualiza el contenido del área de historial.
     */
    private void actualizarHistorial() {
        StringBuilder sb = new StringBuilder();
        for (String mov : historial) {
            sb.append(mov).append("\n");
        }
        txtHistorial.setText(sb.toString());
    }

    /**
     * Cambia de panel en la interfaz.
     */
    private void mostrarPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }
}

