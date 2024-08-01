package main.View.gestionPropuesta;

// importar base
import main.View.gestionBases.*;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FormularioRegistroRecaudos extends VistaBase {
    private JText nombre;
    private JText persona;
    private JComboBox<String> esComunidad;
    private JText RIF;
    private JText CI;
    private JButton botonContinuar;
    private JText pathISLR;
    private JText pathCurriculum;
    private JText pathTitulo;
    private JText pathRegistroMercantil;

    public FormularioRegistroRecaudos() {  
        super("Proponente | Registrar recaudos", 800, 800);

        JPanel panelCentral = crearPanel(false, 0, 0);
        
        // panel de datos
        
        agregarLabel(panelCentral, "Datos personales", true);
        JPanel panelDatos = crearPanel(true, 3, 2);
        // recuadros de texto
        this.nombre = agregarRecuadroTexto(panelDatos, "Nombre", "Ingrese su nombre");
        this.persona = agregarRecuadroTexto(panelDatos, "Persona", "Natural/Juridica");
        this.esComunidad = agregarCombo(panelDatos, "Es de la comunidad","Sí", "No");
        this.RIF = agregarRecuadroTexto(panelDatos, "RIF", "Ingrese su RIF");
        this.CI = agregarRecuadroTexto(panelDatos, "CI", "Ingrese su CI");
        
        // panel de recaudos
        agregarLabel(panelCentral, "Recaudos", true);
        JPanel panelRecaudos = crearPanel(true, 2, 2);
        // botones de adjuntar
        this.pathISLR = agregarBotonAdjunto(panelRecaudos, "Certificado de ISLR", "Adjuntar archivo");
        this.pathCurriculum = agregarBotonAdjunto(panelRecaudos, "Curriculum", "Adjuntar archivo");
        this.pathTitulo = agregarBotonAdjunto(panelRecaudos, "Título universitario", "Adjuntar archivo");
        this.pathRegistroMercantil = agregarBotonAdjunto(panelRecaudos, "Registro mercantil", "Adjuntar archivo");

        // panel de boton continuar
        JPanel panelBoton = crearPanel(false, 0 , 0);
        this.botonContinuar = agregarBoton(panelBoton, "Continuar");

        // agregar paneles a panel central
        panelCentral.add(panelDatos, BorderLayout.NORTH);
        panelCentral.add(panelRecaudos, BorderLayout.CENTER);
        panelCentral.add(panelBoton, BorderLayout.SOUTH);
        agregarPanelCentral(panelCentral, BorderLayout.CENTER);
    }
    
    public String getNombre() {
        return nombre.getText();
    }

    public String getPersona() {
        return persona.getText();
    }

    public String getRIF() {
        return RIF.getText();
    }

    public String getCI() {
        return CI.getText();
    }

    public String getEsComunidad() {
        return (String) esComunidad.getSelectedItem();
    }

    public String getPathISLR() {
        return pathISLR.getText();
    }

    public String getPathCurriculum() {
        return pathCurriculum.getText();
    }

    public String getPathTitulo() {
        return pathTitulo.getText();
    }

    public String getPathRegistroMercantil() {
        return pathRegistroMercantil.getText();
    }

    // setear controlador
    public void setControlador(ActionListener controlador) {
        botonContinuar.addActionListener(controlador);
    }

    // verificar completitud
    public Boolean esDatosRecaudosCompletos(){
        JText[] recuadrosTexto = {this.nombre, this.persona, this.RIF, this.CI};
        if(esDatosCompletos(recuadrosTexto))
           return true;
        return false;
    }

    public static void main(String[] args) {  
        FormularioRegistroRecaudos form = new FormularioRegistroRecaudos();  
        form.setVisible(true);  
    }  
}  