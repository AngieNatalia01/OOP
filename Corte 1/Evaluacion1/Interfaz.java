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
    private JButton btnMonto50, btnMonto100, btnMonto200,  btnConfirmar, btnVolver;
    private JTextField txtMonto; // Campo para ingresar un monto personalizado
    private JLabel lblMensaje, lblSaldo; // Etiquetas para mensajes y saldo
    private JTextArea txtHistorial; // Área para mostrar el historial de movimientos

    // Variables de lógica del cajero
    private double saldo; // Saldo actual
    private boolean esRetiro; // Indica si la operación es un retiro o depósito
    private ArrayList<String> historial; // Lista para almacenar los movimientos
    private DecimalFormat formato; // Formateador para mostrar los montos en formato moneda

    /**
     * Constructor de la interfaz del cajero.
     * Inicializa todos los paneles y configura la ventana principal.
     */
    public Interfaz() {
        setTitle("Cajero Automático");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        saldo = 0.0; // Saldo inicial
        esRetiro = false; // Operación inicial es depósito por defecto
        historial = new ArrayList<>(); // Inicializa el historial de movimientos
        formato = new DecimalFormat("$#.00"); // Formato para mostrar los montos

        iniciarPanelInicial();
        iniciarPanelOpciones();
        iniciarPanelHistorial();

        // Agregar los paneles al contenedor principal
        add(panelInicial, "panelInicial");
        add(panelOpciones, "panelOpciones");
        add(panelHistorial, "panelHistorial");

        mostrarPanel("panelInicial"); // Mostrar el panel inicial al iniciar
    }

    /**
     * Getters y Setters para los atributos privados
     */
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isEsRetiro() {
        return esRetiro;
    }

    public void setEsRetiro(boolean esRetiro) {
        this.esRetiro = esRetiro;
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<String> historial) {
        this.historial = historial;
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

        // Agregar componentes al panel
        panelInicial.add(btnDepositar);
        panelInicial.add(btnRetirar);
        panelInicial.add(btnConsultarSaldo);
        panelInicial.add(btnVerHistorial);
        panelInicial.add(lblSaldo);

        // Acciones de los botones
        btnDepositar.addActionListener(e -> {
            setEsRetiro(false);
            mostrarPanel("panelOpciones");
        });

        btnRetirar.addActionListener(e -> {
            setEsRetiro(true);
            mostrarPanel("panelOpciones");
        });

        btnConsultarSaldo.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Saldo actual: " + formato.format(getSaldo()));
        });

        btnVerHistorial.addActionListener(e -> mostrarPanel("panelHistorial"));
    }

    /**
     * Inicializa el panel de opciones de montos para depósito/retiro.
     */
    private void iniciarPanelOpciones() {
        panelOpciones = new JPanel(new GridLayout(6, 1, 10, 10));

        btnMonto50 = new JButton("$50");
        btnMonto100 = new JButton("$100");
        btnMonto200 = new JButton("$200");
        txtMonto = new JTextField(); // Campo para monto personalizado
        lblMensaje = new JLabel("Selecciona un monto:", JLabel.CENTER);
        btnConfirmar = new JButton("Confirmar");

        panelOpciones.add(lblMensaje);
        panelOpciones.add(btnMonto50);
        panelOpciones.add(btnMonto100);
        panelOpciones.add(btnMonto200);
        panelOpciones.add(btnConfirmar);

        // Acciones de los botones de montos
        btnMonto50.addActionListener(e -> realizarOperacion(50));
        btnMonto100.addActionListener(e -> realizarOperacion(100));
        btnMonto200.addActionListener(e -> realizarOperacion(200));


        // Acción del botón Confirmar
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
     * Inicializa el panel para mostrar el historial de movimientos.
     */
    private void iniciarPanelHistorial() {
        panelHistorial = new JPanel(new BorderLayout(10, 10));
        txtHistorial = new JTextArea();
        txtHistorial.setEditable(false);

        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mostrarPanel("panelInicial"));

        panelHistorial.add(new JScrollPane(txtHistorial), BorderLayout.CENTER);
        panelHistorial.add(btnVolver, BorderLayout.SOUTH);
    }

    /**
     * Realiza la operación de depósito o retiro según la opción seleccionada.
     *
     * @param monto Monto a operar.
     */
    private void realizarOperacion(double monto) {
        if (monto <= 0) {
            JOptionPane.showMessageDialog(this, "El monto debe ser mayor a cero.");
        } else if (isEsRetiro() && monto > getSaldo()) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
        } else {
            setSaldo(getSaldo() + (isEsRetiro() ? -monto : monto));
            String operacion = isEsRetiro() ? "Retiro: -" : "Depósito: +";
            getHistorial().add(operacion + formato.format(monto));
            lblSaldo.setText("Saldo: " + formato.format(getSaldo()));
        }
        txtMonto.setText("");
        actualizarHistorial();
        mostrarPanel("panelInicial");
    }

    /**
     * Actualiza el área de texto del historial con los movimientos registrados.
     */
    private void actualizarHistorial() {
        StringBuilder sb = new StringBuilder();
        for (String mov : getHistorial()) {
            sb.append(mov).append("\n");
        }
        txtHistorial.setText(sb.toString());
    }

    /**
     * Muestra un panel específico en la interfaz.
     *
     * @param panelName Nombre del panel a mostrar.
     */
    private void mostrarPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }
}
