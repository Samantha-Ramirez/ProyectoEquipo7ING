package main.Controller.gestionEvaluacionAval;

import main.View.gestionEvaluacionAval.VistaEvaluacionAval;
import main.Controller.gestionBases.*;

import main.Model.gestionPropuesta.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorEvaluacionAval extends GestorBase {
    private VistaEvaluacionAval vistaEvaluacionAval;
    private VistaError error;
    private Propuesta propuesta;

    public GestorEvaluacionAval(){
        this.vistaEvaluacionAval = new VistaEvaluacionAval();
        this.vistaEvaluacionAval.setVisible(true);
        
        this.vistaEvaluacionAval.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "APROBAR":
                propuesta.aprobarAvalPropuesta();
                //crear curso al aprobar
                new CursoExtension(propuesta);
                // String informacion = ;
                // actualizarArchivo(numeroPropuesta, "true", informacion);
                // String numeroPropuestaText = numeroPropuestaField.getText();
                // try {
                //     int numeroPropuesta = Integer.parseInt(numeroPropuestaText);
                //     if (numeroPropuesta >= 1 && numeroPropuesta <= 20) {
                //         actualizarArchivo(numeroPropuesta, "true", informacion);
                //     } else {
                //         JOptionPane.showMessageDialog(VistaEvaluacionAval.this, "Número de propuesta debe estar entre 1 y 20", "Error", JOptionPane.ERROR_MESSAGE);
                //     }
                // } catch (NumberFormatException ex) {
                //     JOptionPane.showMessageDialog(VistaEvaluacionAval.this, "Número de propuesta inválido", "Error", JOptionPane.ERROR_MESSAGE);
                // }
                break;
            case "RECHAZAR":
                propuesta.setEstado("rechazado", vistaEvaluacionAval.getObservaciones());
                break;
            case "ENVIAR":
                propuesta.actualizarDatos();
                propuesta.getUsuario().actualizarDatos();
                break;
        }
    }
}