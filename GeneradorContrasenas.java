import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GeneradorContrasenas extends JFrame {

    private JTextField nombreField;
    private JTextField correoField;
    private JTextField contrasenaField;
    private JTextArea contrasenasArea;
    private ArrayList<String> contrasenas;

    public GeneradorContrasenas(String title) {
        contrasenas = new ArrayList<>();

        setTitle(title);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JTextField();
        JLabel correoLabel = new JLabel("Correo");
        correoField = new JTextField();

        JButton generarButton = new JButton("Generar");
        JButton guardarButton = new JButton("Guardar");

        inputPanel.add(nombreLabel);
        inputPanel.add(nombreField);
        inputPanel.add(contrasenaLabel);
        inputPanel.add(contrasenaField);
        inputPanel.add(correoLabel);
        inputPanel.add(correoField);
        inputPanel.add(generarButton);
        inputPanel.add(guardarButton);

        contrasenasArea = new JTextArea();
        contrasenasArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(contrasenasArea), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        GeneradorContrasenas generador = new GeneradorContrasenas("Generador de Contrasñas");
    }
}