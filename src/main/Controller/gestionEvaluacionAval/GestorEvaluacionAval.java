package main.Controller.gestionEvaluacionAval;

import main.View.gestionEvaluacionAval.VistaEvaluacionAval;

import main.Model.gestionPropuesta.*;

//importar base
import main.Controller.gestionBases.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorEvaluacionAval extends GestorBase {
    private VistaEvaluacionAval vistaEvaluacionAval;
    private VistaError error;
    private Propuesta propuesta;

    public GestorEvaluacionAval(Propuesta propuesta){
        // setear propuesta a evaluar
        this.propuesta = propuesta;
        this.vistaEvaluacionAval = new VistaEvaluacionAval();
        this.vistaEvaluacionAval.setVisible(true);
        
        this.vistaEvaluacionAval.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "APROBAR":
                // setear estado a aprobado y cambiar proponente a aliado 
                propuesta.aprobarAvalPropuesta();
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
                // setear estado a aprobado y guardar observaciones
                propuesta.rechazarAvalPropuesta(vistaEvaluacionAval.getObservaciones());
                break;
            case "ENVIAR":
                propuesta.actualizarDatos();
                propuesta.getUsuario().actualizarDatos();
                //vistaEvaluacionAval.limpiarCampos();
                vistaEvaluacionAval.setVisible(false);
                break;
        }
    }
}