package main.View.gestionDeEvaluacionAval;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;

public class EvaluacionAval extends JFrame {

    private JTextField recuadroTexto;
    private JTextField numeroPropuestaField;
    private static final String archivoAvalTecnico = "avalTecnico.txt";
    private static final String archivoUsuario = "usuario.txt";

    public EvaluacionAval() {
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

        // Panel central con el recuadro de texto y número de propuesta
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Añadido espacio entre componentes

        recuadroTexto = new JTextField("Información consignada de la propuesta");
        recuadroTexto.setForeground(Color.GRAY);
        recuadroTexto.setPreferredSize(new Dimension(400, 100)); // Ajusta el tamaño para que sea cuadrado
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

        numeroPropuestaField = new JTextField("Número de Propuesta (1-4)");
        numeroPropuestaField.setForeground(Color.GRAY);
        numeroPropuestaField.setPreferredSize(new Dimension(150, 30)); // Ajusta el tamaño
        numeroPropuestaField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (numeroPropuestaField.getText().equals("Número de Propuesta (1-4)")) {
                    numeroPropuestaField.setText("");
                    numeroPropuestaField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (numeroPropuestaField.getText().isEmpty()) {
                    numeroPropuestaField.setForeground(Color.GRAY);
                    numeroPropuestaField.setText("Número de Propuesta (1-4)");
                }
            }
        });

        panelCentral.add(numeroPropuestaField);
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

        // Botón Enviar en el centro inferior
        JPanel panelBotonEnviar = new JPanel();
        panelBotonEnviar.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton botonEnviar= new JButton("Enviar");
        panelBotonEnviar.add(botonEnviar);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        panelInferior.add(panelBotonEnviar, gbc);

        add(panelInferior, BorderLayout.SOUTH);

        // Añadir acción al botón Aprobar
        botonAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String informacion = recuadroTexto.getText();
                String numeroPropuestaText = numeroPropuestaField.getText();
                try {
                    int numeroPropuesta = Integer.parseInt(numeroPropuestaText);
                    if (numeroPropuesta >= 1 && numeroPropuesta <= 4) {
                        actualizarArchivo(numeroPropuesta, "true", informacion);
                    } else {
                        JOptionPane.showMessageDialog(EvaluacionAval.this, "Número de propuesta debe estar entre 1 y 4", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EvaluacionAval.this, "Número de propuesta inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Añadir acción al botón Enviar
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizararchivoUsuario();
            }
        });
    }

    private void actualizarArchivo(int numeroPropuesta, String estado, String informacion) {
        if (Files.exists(Paths.get(archivoAvalTecnico))) {
            try {
                // Leer el contenido del archivo
                BufferedReader reader = new BufferedReader(new FileReader(archivoAvalTecnico));
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    // Modificar la línea correspondiente
                    if (linea.startsWith("Propuesta nro " + numeroPropuesta + ":")) {
                        String[] partes = linea.split(": ", 2);
                        if (partes.length == 2) {
                            String[] subPartes = partes[1].split(", ", 2);
                            subPartes[0] = "Estado = " + estado;
                            subPartes[1] = "Información = " + informacion;
                            linea = partes[0] + ": " + String.join(", ", subPartes);
                        }
                    }
                    contenido.append(linea).append(System.lineSeparator());
                }
                reader.close();

                // Escribir el contenido modificado de nuevo al archivo
                FileWriter writer = new FileWriter(archivoAvalTecnico);
                writer.write(contenido.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void actualizararchivoUsuario() {
        if (Files.exists(Paths.get(archivoUsuario))) {
            try {
                // Leer el contenido del archivo
                BufferedReader reader = new BufferedReader(new FileReader(archivoUsuario));
                StringBuilder contenido = new StringBuilder();
                String linea = reader.readLine();

                // Verificar y modificar la primera línea si es necesario
                if (linea != null && linea.startsWith("Proponente")) {
                    contenido.append("Aliado").append(System.lineSeparator());
                } else if (linea != null) {
                    contenido.append(linea).append(System.lineSeparator());
                }

                // Leer el resto del archivo
                while ((linea = reader.readLine()) != null) {
                    contenido.append(linea).append(System.lineSeparator());
                }
                reader.close();

                // Escribir el contenido modificado de nuevo al archivo
                FileWriter writer = new FileWriter(archivoUsuario);
                writer.write(contenido.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EvaluacionAval().setVisible(true));
    }
}
