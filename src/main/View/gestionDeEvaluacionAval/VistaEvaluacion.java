package main.View.gestionDeEvaluacionAval;

import java.awt.*;
import javax.swing.*;

public class VistaEvaluacion extends JFrame {

    public VistaEvaluacion() {
        // Configuración de la ventana principal
        setTitle("Administrador | Evaluación de aval");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(Color.BLACK);
        JLabel titulo = new JLabel("Administrador | Evaluación de aval", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        panelSuperior.add(titulo, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con el recuadro de texto
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 80)); // Añadido espacio entre componentes
        
        JTextField recuadroTexto = new JTextField("Información consignada de la propuesta");
        recuadroTexto.setForeground(Color.GRAY);
        recuadroTexto.setPreferredSize(new Dimension(500, 100)); // Ajusta el tamaño para que sea cuadrado
        recuadroTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (recuadroTexto.getText().equals("Información consignada de la propuesta")) {
                    recuadroTexto.setText("");
                    recuadroTexto.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (recuadroTexto.getText().isEmpty()) {
                    recuadroTexto.setForeground(Color.GRAY);
                    recuadroTexto.setText("Información consignada de la propuesta");
                }
            }
        });
        panelCentral.add(recuadroTexto);
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
        JButton botonAprobar = new JButton("Aprobar");
        JButton botonRechazar = new JButton("Rechazar");
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
        JTextField cuadroTextoObservaciones = new JTextField("Escriba aca");
        cuadroTextoObservaciones.setForeground(Color.GRAY);
        cuadroTextoObservaciones.setPreferredSize(new Dimension(100, 60)); // Ajusta el tamaño para que sea cuadrado
        cuadroTextoObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (cuadroTextoObservaciones.getText().equals("Escriba aca")) {
                    cuadroTextoObservaciones.setText("");
                    cuadroTextoObservaciones.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (cuadroTextoObservaciones.getText().isEmpty()) {
                    cuadroTextoObservaciones.setForeground(Color.GRAY);
                    cuadroTextoObservaciones.setText("Escriba aca");
                }
            }
        });
        panelObservaciones.add(subtituloObservaciones);
        panelObservaciones.add(Box.createRigidArea(new Dimension(0, 5)));
        panelObservaciones.add(cuadroTextoObservaciones);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        panelInferior.add(panelObservaciones, gbc);

        // Botón Enviar en el centro
        JPanel panelBotonEnviar = new JPanel();
        panelBotonEnviar.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton botonEnviar = new JButton("Enviar");
        panelBotonEnviar.add(botonEnviar);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        panelInferior.add(panelBotonEnviar, gbc);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaEvaluacion evaluacionAval = new VistaEvaluacion();
            evaluacionAval.setVisible(true);
        });
    }
}
