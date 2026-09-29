/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    
package consumoelectrico;

import javax.swing.*;
import java.awt.*;

/*
 * Autor: LUIS GADIEL HERNANDEZ BAUTISTA
 * Proyecto: Calculadora de Consumo Eléctrico
 * Interfaz gráfica mediante Java Swing.
 */

public class VentanaPrincipal extends JFrame {

    private JTextField txtNombre;
    private JTextField txtPotencia;
    private JTextField txtHoras;
    private JTextField txtPrecio;

    private JTextArea resultado;

    public VentanaPrincipal() {

        setTitle("Calculadora de Consumo Eléctrico");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel titulo = new JLabel(
                "CALCULADORA DE CONSUMO ELÉCTRICO",
                SwingConstants.CENTER
        );

        JLabel autor = new JLabel(
                "Autor: LUIS GADIEL HERNANDEZ BAUTISTA",
                SwingConstants.CENTER
        );

        txtNombre = new JTextField();
        txtPotencia = new JTextField();
        txtHoras = new JTextField();
        txtPrecio = new JTextField();

        panel.add(new JLabel("Nombre del aparato:"));
        panel.add(txtNombre);

        panel.add(new JLabel("Potencia (Watts):"));
        panel.add(txtPotencia);

        panel.add(new JLabel("Horas de uso al día:"));
        panel.add(txtHoras);

        panel.add(new JLabel("Precio por kWh:"));
        panel.add(txtPrecio);

        JButton calcular = new JButton("Calcular consumo");
        JButton limpiar = new JButton("Limpiar");

        panel.add(calcular);
        panel.add(limpiar);

        resultado = new JTextArea();
        resultado.setEditable(false);

        calcular.addActionListener(e -> calcular());
        limpiar.addActionListener(e -> limpiar());

        setLayout(new BorderLayout(10, 10));

        add(titulo, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        JPanel inferior = new JPanel(new BorderLayout());

        inferior.add(autor, BorderLayout.NORTH);
        inferior.add(new JScrollPane(resultado), BorderLayout.CENTER);

        add(inferior, BorderLayout.SOUTH);
    }

    private void calcular() {

        try {

            String nombre = txtNombre.getText();

            double potencia = Double.parseDouble(txtPotencia.getText());
            double horas = Double.parseDouble(txtHoras.getText());
            double precio = Double.parseDouble(txtPrecio.getText());

            ConsumoDomestico consumo = new ConsumoDomestico(
                    nombre,
                    potencia,
                    horas,
                    "Aparato doméstico"
            );

            double costo = consumo.calcularCostoMensual(precio);

            resultado.setText(
                    consumo.obtenerResumen()
                    + "\nCosto mensual aproximado: $"
                    + String.format("%.2f", costo)
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Introduce valores numéricos válidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void limpiar() {

        txtNombre.setText("");
        txtPotencia.setText("");
        txtHoras.setText("");
        txtPrecio.setText("");
        resultado.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VentanaPrincipal ventana = new VentanaPrincipal();

            ventana.setVisible(true);
        });
    }
}
