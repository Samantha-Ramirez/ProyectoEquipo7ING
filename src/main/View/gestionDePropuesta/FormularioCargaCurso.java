package main.View.gestionDePropuesta;

import java.awt.*;
import javax.swing.*;

import main.View.abstractas.*;

public class FormularioCargaCurso extends VentanaPrincipal {  

    public FormularioCargaCurso() {  
        super("Proponente | Cargar formulacion");

        JPanel panelCentral = crearPanel(false, 0, 0);

        JPanel panelAdjuntos = crearPanel(true, 9, 1);
        agregarRecuadroTexto(panelAdjuntos, "Unidad responsable", "Ingrese unidad");
        agregarRecuadroTexto(panelAdjuntos, "Denominación", "Ingrese denominación");
        agregarRecuadroTexto(panelAdjuntos, "Fundamentación", "Ingrese fundamentación");
        agregarRecuadroTexto(panelAdjuntos, "Duración", "Ingrese duración");
        agregarBotonAdjunto(panelAdjuntos, "Perfiles de participantes", "Adjuntar archivo");
        agregarBotonAdjunto(panelAdjuntos, "Perfil de docente", "Adjuntar archivo");
        agregarBotonAdjunto(panelAdjuntos, "Estructura curricular", "Adjuntar archivo");
        agregarBotonAdjunto(panelAdjuntos, "Estrategias de evaluación", "Adjuntar archivo");
        agregarBotonAdjunto(panelAdjuntos, "Exigencias", "Adjuntar archivo");

        JPanel panelBoton = crearPanel(false, 0 , 0);
        agregarBoton(panelBoton, "Enviar");

        panelCentral.add(panelAdjuntos, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);

        agregarPanelCentral(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) { 
        FormularioCargaCurso form = new FormularioCargaCurso();  
        form.setVisible(true);  
    }  
}  
