package main.View.gestionCursosPropuestos;

// importar base
import main.View.gestionBases.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class VistaExpediente extends VistaBase {
    private JButton botonFirmar;
    private JButton botonRechazar;

    public VistaExpediente() {  
        super("Proponente | Expediente", 600, 400);

        JPanel panelCentral = crearPanel(false, 0, 0);
        
        // panel de datos
        
        agregarLabel(panelCentral, "Cartas de intencion", true);
        //JPanel panelDatos = crearPanel(true, 3, 2);
        
        // panel de recaudos
        agregarLabel(panelCentral, "Cartas de compromiso", true);
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
    }
}  
