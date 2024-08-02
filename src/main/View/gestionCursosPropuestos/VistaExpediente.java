package main.View.gestionCursosPropuestos;

// importar base
import main.View.gestionBases.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.*;

public class VistaExpediente extends VistaBase {
    private JButton botonFirmar;
    private JButton botonRechazar;
    private JButton botonAbrir;

    public VistaExpediente(Vector<String> cartas) {  
        super("Proponente | Expediente", 600, 400);

        JPanel panelCentral = crearPanel(false, 0, 0);
        
        // panel de datos
        
        // JLabel cartaLabel = new JLabel("Cartas");
        // JPanel panelDatos = crearPanel(true, 3, 2);
        // Panel central con los componentes
        panelCentral.setLayout(new GridLayout(cartas.size(), 3, 10, 10)); // Ajustar filas según los cursos
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega borde vacío para centrado
        this.botonFirmar = new JButton("Firmar");
        this.botonRechazar = new JButton("Rechazar");
        this.botonAbrir = new JButton("Abrir");

        for (String carta : cartas) {
            JPanel lineaPanel = new JPanel();
            lineaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centra los componentes dentro de la línea

            JLabel cursoLabel = new JLabel(carta + " - "); // Reemplazar "Curso #1" con la carta del archivo

            JButton btnFirmar = new JButton("Firmar");
            btnFirmar.setActionCommand("FIRMAR"); // Establece un comando de acción con la carta

            JButton btnRechazar = new JButton("Rechazar");
            btnRechazar.setActionCommand("RECHAZAR"); // Establece un comando de acción con la carta

            JButton btnAbrir = new JButton("Abrir");
            btnAbrir.setActionCommand("ABRIR:"+carta); // Establece un comando de acción con la carta
            
            // Acción para el botón "Responder evaluación de aval"
            btnAbrir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    botonAbrir.setActionCommand(command);
                    botonAbrir.doClick();
                }
            });
            btnFirmar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    botonFirmar.setActionCommand(command);
                    botonFirmar.doClick();
                }
            });
            btnRechazar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    botonRechazar.setActionCommand(command);
                    botonRechazar.doClick();
                }
            });
            
            lineaPanel.add(cursoLabel);
            lineaPanel.add(btnFirmar);
            lineaPanel.add(btnRechazar);
            lineaPanel.add(btnAbrir);
            
            panelCentral.add(lineaPanel);
        }
        // panelCentral.add(cartaLabel);

        add(panelCentral, BorderLayout.CENTER);
        
        // panel de recaudos
        //JPanel panelRecaudos = crearPanel(true, 2, 2);

        // agregar paneles a panel central
        //panelCentral.add(panelDatos, BorderLayout.NORTH);
        //panelCentral.add(panelRecaudos, BorderLayout.CENTER);
        agregarPanelCentral(panelCentral, BorderLayout.CENTER);
    }
    
    // setear controlador
    public void setControlador(ActionListener controlador) {
        botonFirmar.addActionListener(controlador);
        botonRechazar.addActionListener(controlador);
        botonAbrir.addActionListener(controlador);
    }
}  
