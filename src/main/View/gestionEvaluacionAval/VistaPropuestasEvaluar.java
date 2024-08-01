package main.View.gestionEvaluacionAval;

import main.Controller.gestionEvaluacionAval.GestorEvaluacionAval;
import main.Model.gestionPropuesta.Propuesta;
import main.Model.gestionSesionUsuario.*; // FIX:dependencia
// importar base
import main.View.gestionBases.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

public class VistaPropuestasEvaluar extends VistaBase {

    public VistaPropuestasEvaluar(Vector<String> propuestas) {
        super("Administrador | Ver propuestas a evaluar", 600, 400);

        // Panel central con los componentes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(propuestas.size(), 1, 10, 10)); // Ajustar filas según los cursos
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega borde vacío para centrado

        for (String propuesta : propuestas) {
            String[] partes = propuesta.split(",");
            JPanel lineaPanel = new JPanel();
            lineaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centra los componentes dentro de la línea

            JLabel cursoLabel = new JLabel(partes[0] + " - "); // Reemplazar "Curso #1" con la propuesta del archivo

            JButton btnResponderEvaluacion = new JButton("Responder evaluación de aval");
            btnResponderEvaluacion.setActionCommand(propuesta); // Establece un comando de acción con la propuesta

            JButton btnGenerarCarta = new JButton("Generar carta de compromiso");
            JButton btnFirmaCarta = new JButton("Firma carta de intencion");
            
            // Acción para el botón "Responder evaluación de aval"
            btnResponderEvaluacion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String propuestaString = e.getActionCommand();
                    String[] partes = propuestaString.split(",");
                    // Abre la ventana de Evaluación de Aval
                    Usuario usuario = new Usuario(partes[0]);
                    Propuesta propuesta = new Propuesta(
                        usuario, partes[1], partes[2], partes[3], 
                        partes[4], partes[5], partes[6], partes[7], 
                        partes[8], partes[9], partes[10]);
                    new GestorEvaluacionAval(propuesta);
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
}
