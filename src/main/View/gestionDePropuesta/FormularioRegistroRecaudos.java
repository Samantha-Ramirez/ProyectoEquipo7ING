package main.View.gestionDePropuesta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import main.View.abstractas.*;

public class FormularioRegistroRecaudos extends VentanaPrincipal {
    JText nombre;
    JText persona;
    JText esComunidad;
    JText RIF;
    JText CI;
    VistaError error;

    public FormularioRegistroRecaudos() {  
        super("Proponente | Registrar recaudos");

        JPanel panelCentral = crearPanel(false, 0, 0);
        
        // panel de datos
        JPanel panelDatos = crearPanel(true, 3, 2);
        agregarLabel(panelCentral, "Datos personales", true);
        // recuadros de texto
        this.nombre = agregarRecuadroTexto(panelDatos, "Nombre", "Ingrese su nombre");
        this.persona = agregarRecuadroTexto(panelDatos, "Persona", "Natural/Juridica");
        this.esComunidad = agregarRecuadroTexto(panelDatos, "Es de la comunidad", "Sí/No");
        this.RIF = agregarRecuadroTexto(panelDatos, "RIF", "Ingrese su RIF");
        this.CI = agregarRecuadroTexto(panelDatos, "CI", "Ingrese su CI");
        
        // panel de recaudos
        JPanel panelRecaudos = crearPanel(true, 2, 2);
        agregarLabel(panelCentral, "Recaudos", true);
        // botones de adjuntar
        agregarBotonAdjunto(panelRecaudos, "Certificado de ISLR", "Adjuntar archivo");
        agregarBotonAdjunto(panelRecaudos, "Curriculum", "Adjuntar archivo");
        agregarBotonAdjunto(panelRecaudos, "Título universitario", "Adjuntar archivo");
        agregarBotonAdjunto(panelRecaudos, "Registro mercantil", "Adjuntar archivo");

        // panel de boton continuar
        JPanel panelBoton = crearPanel(false, 0 , 0);
        JButton boton = agregarBoton(panelBoton, "Continuar");
        // abrir ventana de Cargar formulacion de curso
        FormularioCargaCurso form = new FormularioCargaCurso();
        // listener
        botonAbrirVentana(boton, form);

        // agregar paneles a panel central
        panelCentral.add(panelDatos, BorderLayout.NORTH);
        panelCentral.add(panelRecaudos, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);
        agregarPanelCentral(panelCentral, BorderLayout.CENTER);
    }
    
    public void esDatosRecaudosCompletos(Ventana ventana){
        JText[] recuadrosTexto = {this.nombre, this.persona, this.esComunidad, this.RIF, this.CI};
        if(!esDatosCompletos(recuadrosTexto)){
            error = new VistaError("Debe completar");
        }else{
            ventana.setVisible(true);
        }
    }

    @Override public void botonAbrirVentana(JButton boton, Ventana ventana){
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esDatosRecaudosCompletos(ventana);
            }
        });
    }

    public static void main(String[] args) {  
        FormularioRegistroRecaudos form = new FormularioRegistroRecaudos();  
        form.setVisible(true);  
    }  
}  