import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GeneradorContrasenas extends JFrame {

    private JTextField nombreField;
    private JTextField correoField;
    private JTextField contrasenaField;
    private JTextArea contrasenasArea;
    private ArrayList<String> contrasenas;

    public GeneradorContrasenas() {
        contrasenas = new ArrayList<>();

        setTitle("Generador de Contraseñas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //              Colum1            Colum2
        //row1          Nombre                    
        //row2          Contrasena                
        //row3          Correo       
        //row4          Generar           Guardar
        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JTextField();
        JLabel correoLabel = new JLabel("Correo");
        correoField = new JTextField();

        JButton generarButton = new JButton("Generar");
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarContrasena();
            }
        });

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarContrasena();
            }
        });

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

    private void generarContrasena() {
        String contrasenaGenerada = generarContrasenaAleatoria();
        contrasenaField.setText(contrasenaGenerada);
    }

    private String generarContrasenaAleatoria() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_!$%&/()=?¡¿";
        Random rand = new Random();
        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int index = rand.nextInt(caracteres.length());
            contrasena.append(caracteres.charAt(index));
        }
        return contrasena.toString();
    }

    private void guardarContrasena() {
        String nombre = nombreField.getText();
        String contrasena = contrasenaField.getText();
        String correo = correoField.getText();

        if (!nombre.isEmpty() && !contrasena.isEmpty() && !correo.isEmpty()) {
            String nuevaContrasena = "Nombre: " + nombre + "\nContraseña: " + contrasena + "\nCorreo: " + correo + "\n";

            contrasenas.add(nuevaContrasena);
            mostrarContrasena(contrasenas.size() - 1);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre y una contraseña.");
        }
    }

    private void editarContrasenas() {
        contrasenasArea.setEditable(true);
    }

    private void mostrarContrasena(int index) {
        contrasenasArea.append(contrasenas.get(index) + "\n");
        System.out.println(contrasenas.get(index));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GeneradorContrasenas();
            }
        });
    }
}