package main.View.gestionDePropuesta;

import java.awt.*;
import javax.swing.*;

import main.View.abstractas.*;

public class FormularioRegistroRecaudos extends VentanaPrincipal {  

    public FormularioRegistroRecaudos(String title) {  
        super(title);

        JPanel panelCentral = crearPanel(false, 0, 0);

        JPanel panelDatos = crearPanel(true, 3, 2);
        agregarLabel(panelCentral, "Datos personales", true);
        agregarRecuadroTexto(panelDatos, "Nombre", "Ingrese su nombre");
        agregarRecuadroTexto(panelDatos, "Persona", "Natural/Juridica");
        agregarRecuadroTexto(panelDatos, "Es de la comunidad", "Sí/No");
        agregarRecuadroTexto(panelDatos, "RIF", "Ingrese su RIF");
        agregarRecuadroTexto(panelDatos, "CI", "Ingrese su CI");
        
        JPanel panelRecaudos = crearPanel(true, 2, 2);
        agregarLabel(panelCentral, "Recaudos", true);
        agregarRecuadroTexto(panelRecaudos, "Certificado de ISLR", "Adjuntar archivo");
        agregarRecuadroTexto(panelRecaudos, "Curriculum", "Adjuntar archivo");
        agregarRecuadroTexto(panelRecaudos, "Título universitario", "Adjuntar archivo");
        agregarRecuadroTexto(panelRecaudos, "Registro mercantil", "Adjuntar archivo");

        JPanel panelBoton = crearPanel(false, 0 , 0);
        JButton boton = agregarBoton(panelBoton, "Continuar");
        FormularioCargaCurso form = new FormularioCargaCurso("Proponente | Cargar formulacion");
        botonAbrirVentana(boton, form);

        panelCentral.add(panelDatos, BorderLayout.NORTH);
        panelCentral.add(panelRecaudos, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);

        agregarPanel(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {  
        FormularioRegistroRecaudos form = new FormularioRegistroRecaudos("Proponente | Registrar recaudos");  
        form.setVisible(true);  
    }  
}  