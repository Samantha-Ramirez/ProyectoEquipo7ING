package main.View.gestionEvaluacionAval;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import main.View.gestionBases.VistaBase;

public class VistaEvaluacionAval extends VistaBase {
    private JTextField recuadroTextoInfoConsignada;
    private JTextField recuadroTextoObservaciones;
    private JButton botonAprobar;
    private JButton botonRechazar;
    private JButton botonEnviar;

    public VistaEvaluacionAval() {
        super("Administrador | Evaluación de aval", 600, 400);

        // Panel central con el recuadro de texto y número de propuesta
        JPanel panelCentral = crearPanel(false, 0, 0);
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Añadido espacio entre componentes

        recuadroTextoInfoConsignada = new JTextField("Información consignada de la propuesta");
        recuadroTextoInfoConsignada.setForeground(Color.GRAY);
        recuadroTextoInfoConsignada.setPreferredSize(new Dimension(400, 100)); // Ajusta el tamaño para que sea cuadrado
        recuadroTextoInfoConsignada.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (recuadroTextoInfoConsignada.getText().equals("Información consignada de la propuesta")) {
                    recuadroTextoInfoConsignada.setText("");
                    recuadroTextoInfoConsignada.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (recuadroTextoInfoConsignada.getText().isEmpty()) {
                    recuadroTextoInfoConsignada.setForeground(Color.GRAY);
                    recuadroTextoInfoConsignada.setText("Información consignada de la propuesta");
                }
            }
        });

        // recuadroTextoObservaciones = new JTextField("Número de Propuesta");
        // recuadroTextoObservaciones.setForeground(Color.GRAY);
        // recuadroTextoObservaciones.setPreferredSize(new Dimension(150, 30)); // Ajusta el tamaño
        // recuadroTextoObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
        //     @Override
        //     public void focusGained(java.awt.event.FocusEvent evt) {
        //         if (recuadroTextoObservaciones.getText().equals("Número de Propuesta (1-4)")) {
        //             recuadroTextoObservaciones.setText("");
        //             recuadroTextoObservaciones.setForeground(Color.BLACK);
        //         }
        //     }
        //     @Override
        //     public void focusLost(java.awt.event.FocusEvent evt) {
        //         if (recuadroTextoObservaciones.getText().isEmpty()) {
        //             recuadroTextoObservaciones.setForeground(Color.GRAY);
        //             recuadroTextoObservaciones.setText("Número de Propuesta (1-4)");
        //         }
        //     }
        // });

        // panelCentral.add(recuadroTextoObservaciones);
        panelCentral.add(recuadroTextoInfoConsignada);
        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior con los botones y subtítulos
        JPanel panelInferior = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Panel de evaluación en el extremo inferior izquierdo
        JPanel panelEvaluacion = new JPanel();
        panelEvaluacion.setLayout(new BoxLayout(panelEvaluacion, BoxLayout.Y_AXIS));
        JLabel subtituloEvaluacion = new JLabel("Evaluación");
        this.botonAprobar = new JButton("Aprobar");
        this.botonAprobar.setActionCommand("APROBAR"); // Establece un comando de acción
        this.botonRechazar = new JButton("Rechazar");
        this.botonRechazar.setActionCommand("RECHAZAR"); // Establece un comando de acción
        panelEvaluacion.add(subtituloEvaluacion);
        panelEvaluacion.add(Box.createRigidArea(new Dimension(0, 5)));
        panelEvaluacion.add(botonAprobar);
        panelEvaluacion.add(Box.createRigidArea(new Dimension(0, 5)));
        panelEvaluacion.add(botonRechazar);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        panelInferior.add(panelEvaluacion, gbc);

        // Panel de observaciones en el extremo inferior derecho
        JPanel panelObservaciones = new JPanel();
        panelObservaciones.setLayout(new BoxLayout(panelObservaciones, BoxLayout.Y_AXIS));
        JLabel subtituloObservaciones = new JLabel("Observaciones");
        recuadroTextoObservaciones = new JTextField("Escribir observaciones");
        recuadroTextoObservaciones.setForeground(Color.GRAY);
        recuadroTextoObservaciones.setPreferredSize(new Dimension(100, 60)); // Ajusta el tamaño para que sea cuadrado
        recuadroTextoObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (recuadroTextoObservaciones.getText().equals("Escribir observaciones")) {
                    recuadroTextoObservaciones.setText("");
                    recuadroTextoObservaciones.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (recuadroTextoObservaciones.getText().isEmpty()) {
                    recuadroTextoObservaciones.setForeground(Color.GRAY);
                    recuadroTextoObservaciones.setText("Escribir observaciones");
                }
            }
        });
        panelObservaciones.add(subtituloObservaciones);
        panelObservaciones.add(Box.createRigidArea(new Dimension(0, 5)));
        panelObservaciones.add(recuadroTextoObservaciones);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        panelInferior.add(panelObservaciones, gbc);

        // Botón Enviar en el centro inferior
        JPanel panelBotonEnviar = new JPanel();
        panelBotonEnviar.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.botonEnviar = new JButton("Enviar");
        this.botonEnviar.setActionCommand("ENVIAR"); // Establece un comando de acción
        panelBotonEnviar.add(botonEnviar);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        panelInferior.add(panelBotonEnviar, gbc);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public void setControlador(ActionListener controlador) {
        botonAprobar.addActionListener(controlador);
        botonRechazar.addActionListener(controlador);
        botonEnviar.addActionListener(controlador);
    }

    public String getObservaciones(){
        return recuadroTextoObservaciones.getText();
    }
    
    public static void main(String[] args) {
        // SwingUtilities.invokeLater(() -> new VistaEvaluacionAval().setVisible(true));
        VistaEvaluacionAval vistaEvaluacionAval = new VistaEvaluacionAval();  
        vistaEvaluacionAval.setVisible(true);  
    }
}
