package main.View.gestionDePropuesta;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import main.View.abstractas.*;

public class FormularioCargaCurso extends VentanaPrincipal {  
    private JText nombre;
    private JText unidadResponsableDeTramite;
    private JText denominacion;
    private JText duracion;
    private JText fundamentacion;
    private JButton archivoPerfilParticipantes;
    private JButton archivoPerfilDocente;
    private JButton archivoCurriculoCompetencias;
    private JButton archivoEstrategiasEvaluacion;
    private JButton archivoExigenciasMaterialesYServicios;
    private JButton botonEnviar;
    
    public FormularioCargaCurso() {  
        super("Proponente | Cargar formulación");

        JPanel panelCentral = crearPanel(false, 0, 0);

        JPanel panelAdjuntos = crearPanel(true, 10, 1);
        this.nombre = agregarRecuadroTexto(panelAdjuntos, "Nombre", "Ingrese nombre");
        this.unidadResponsableDeTramite = agregarRecuadroTexto(panelAdjuntos, "Unidad responsable", "Ingrese unidad");
        this.denominacion = agregarRecuadroTexto(panelAdjuntos, "Denominación", "Ingrese denominación");
        this.fundamentacion = agregarRecuadroTexto(panelAdjuntos, "Fundamentación", "Ingrese fundamentación");
        this.duracion = agregarRecuadroTexto(panelAdjuntos, "Duración", "Ingrese duración");
        this.archivoPerfilParticipantes = agregarBotonAdjunto(panelAdjuntos, "Perfiles de participantes", "Adjuntar archivo");
        this.archivoPerfilDocente = agregarBotonAdjunto(panelAdjuntos, "Perfil de docente", "Adjuntar archivo");
        this.archivoCurriculoCompetencias = agregarBotonAdjunto(panelAdjuntos, "Estructura curricular", "Adjuntar archivo");
        this.archivoEstrategiasEvaluacion = agregarBotonAdjunto(panelAdjuntos, "Estrategias de evaluación", "Adjuntar archivo");
        this.archivoExigenciasMaterialesYServicios = agregarBotonAdjunto(panelAdjuntos, "Exigencias", "Adjuntar archivo");

        JPanel panelBoton = crearPanel(false, 0 , 0);
        this.botonEnviar = agregarBoton(panelBoton, "Enviar");

        panelCentral.add(panelAdjuntos, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);

        agregarPanelCentral(panelCentral, BorderLayout.CENTER);
    }

    public String getNombre() {
        return nombre.getText();
    }

    public String getUnidadResponsableDeTramite() {
        return unidadResponsableDeTramite.getText();
    }

    public String getDenominacion() {
        return denominacion.getText();
    }

    public String getDuracion() {
        return duracion.getText();
    }

    public String getFundamentacion() {
        return fundamentacion.getText();
    }

    public void setControlador(ActionListener controlador) {
        botonEnviar.addActionListener(controlador);
    }

    public Boolean esDatosRecaudosCompletos(){
        JText[] recuadrosTexto = {this.nombre, this.unidadResponsableDeTramite, this.denominacion, this.duracion, this.fundamentacion};
        if(esDatosCompletos(recuadrosTexto))
           return true;
        return false;
    }

    public static void main(String[] args) { 
        FormularioCargaCurso form = new FormularioCargaCurso();  
        form.setVisible(true);  
    }  
}  
