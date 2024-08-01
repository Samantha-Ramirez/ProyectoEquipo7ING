package main.View.gestionDeEvaluacionAval;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class VistaPropuestasEvaluar extends JFrame {

    public VistaPropuestasEvaluar() {
        // Configuración de la ventana principal
        setTitle("Evaluaciones | Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.BLACK);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centra el contenido
        JLabel titulo = new JLabel("Evaluaciones | Dashboard");
        titulo.setForeground(Color.WHITE);
        panelSuperior.add(titulo);
        add(panelSuperior, BorderLayout.NORTH);

        // Leer datos del archivo
        ArrayList<String[]> cursosData = leerDatosCurso("CursoExtension.txt");

        // Panel central con los componentes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(cursosData.size(), 1, 10, 10)); // Ajustar filas según los cursos
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega borde vacío para centrado

        for (int i = 0; i < cursosData.size(); i++) {
            String[] curso = cursosData.get(i);
            JPanel lineaPanel = new JPanel();
            lineaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centra los componentes dentro de la línea

            JLabel cursoLabel = new JLabel(curso[1] + " - "); // Reemplazar "Curso #1" con la propuesta del archivo
            JButton btnResponderEvaluacion = new JButton("Responder evaluación de aval");
            JButton btnGenerarCarta = new JButton("Generar carta de compromiso");
            JButton btnFirmaCarta = new JButton("Firma carta de intencion");
            
            // Acción para el botón "Responder evaluación de aval"
            btnResponderEvaluacion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre la ventana de Evaluación de Aval
                    VistaEvaluacionAval evaluacionAvalFrame = new VistaEvaluacionAval();
                    evaluacionAvalFrame.setVisible(true);
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

    private ArrayList<String[]> leerDatosCurso(String archivo) {
        ArrayList<String[]> cursosData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                cursosData.add(datos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cursosData;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaPropuestasEvaluar dashboard = new VistaPropuestasEvaluar();
            dashboard.setVisible(true);
        });
    }
}
