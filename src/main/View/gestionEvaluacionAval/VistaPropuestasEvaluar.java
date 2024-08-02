package main.View.gestionEvaluacionAval;

// importar base
import main.View.gestionBases.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

public class VistaPropuestasEvaluar extends VistaBase {
    private JButton botonResponderEvaluacion;
    private JButton botonGenerarCarta;
    private JButton botonFirmaCarta;

    public VistaPropuestasEvaluar(Vector<String> propuestas) {
        super("Administrador | Ver propuestas a evaluar", 600, 400);

        // Panel central con los componentes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(propuestas.size(), 1, 10, 10)); // Ajustar filas según los cursos
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega borde vacío para centrado
        this.botonResponderEvaluacion = new JButton("Responder evaluación de aval");
        this.botonGenerarCarta = new JButton("Generar carta de compromiso");
        this.botonFirmaCarta = new JButton("Firma carta de intencion");

        for (String propuesta : propuestas) {
            String[] partes = propuesta.split(",");
            JPanel lineaPanel = new JPanel();
            lineaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centra los componentes dentro de la línea

            JLabel cursoLabel = new JLabel(partes[2] + " - "); // Reemplazar "Curso #1" con la propuesta del archivo

            JButton btnResponderEvaluacion = new JButton("Responder evaluación de aval");
            btnResponderEvaluacion.setActionCommand("EVALUACION,"+propuesta); // Establece un comando de acción con la propuesta

            JButton btnGenerarCarta = new JButton("Generar carta de compromiso");
            btnGenerarCarta.setActionCommand("CARTACOMPROMISO"); // Establece un comando de acción con la propuesta

            JButton btnFirmaCarta = new JButton("Firma carta de intencion");
            btnFirmaCarta.setActionCommand("CARTAINTENCION"); // Establece un comando de acción con la propuesta
            
            // Acción para el botón "Responder evaluación de aval"
            btnResponderEvaluacion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    botonResponderEvaluacion.setActionCommand(command);
                    botonResponderEvaluacion.doClick();
                }
            });

            btnGenerarCarta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    botonGenerarCarta.setActionCommand(command);
                    botonGenerarCarta.doClick();
                }
            });

            btnFirmaCarta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    botonFirmaCarta.setActionCommand(command);
                    botonFirmaCarta.doClick();
                }
            });
            
            lineaPanel.add(cursoLabel);
            lineaPanel.add(btnResponderEvaluacion);
            lineaPanel.add(btnGenerarCarta);
            lineaPanel.add(btnFirmaCarta);
            
            panelCentral.add(lineaPanel);
        }

        add(panelCentral, BorderLayout.CENTER);
    }
    public void setControlador(ActionListener controlador) {
        botonResponderEvaluacion.addActionListener(controlador);
        botonGenerarCarta.addActionListener(controlador);
        botonFirmaCarta.addActionListener(controlador);
    }
}
