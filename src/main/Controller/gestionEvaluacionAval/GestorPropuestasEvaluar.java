package main.Controller.gestionEvaluacionAval;

import main.View.gestionEvaluacionAval.VistaEvaluacionAval;
import main.View.gestionEvaluacionAval.VistaPropuestasEvaluar;
import main.Model.gestionPropuesta.Propuesta;
import main.Model.gestionSesionUsuario.Usuario;
//importar base
import main.Controller.gestionBases.*;

import java.awt.event.ActionEvent;
import java.util.Vector;
import java.awt.event.ActionListener;

public class GestorPropuestasEvaluar extends GestorBase {
    //Atributos
    private Vector<String> propuestas;
    private VistaPropuestasEvaluar vistaPropuestasEvaluar;
    private VistaError error;
    // Constructor
    public GestorPropuestasEvaluar(){
        this.propuestas = new Vector<>();

        // Busca la informacion de los cursos
        Propuesta propuesta = new Propuesta("");
        // guarda la informacion de los cursos
        propuestas = propuesta.getPropuestas(false, true);
        // muestra la interfaz con la informacion extraida
        this.vistaPropuestasEvaluar = new VistaPropuestasEvaluar(propuestas);
        if(propuestas.size()>0){
            vistaPropuestasEvaluar.setVisible(true);
        }else{
            vistaPropuestasEvaluar.mostrarMensaje("No hay propuestas");
        }
        
        this.vistaPropuestasEvaluar.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String propuestaString = e.getActionCommand();
        Propuesta propuesta = transformarAPropuesta(propuestaString);
        new GestorEvaluacionAval(propuesta);
    }

    public Propuesta transformarAPropuesta(String propuestaString){
        String[] partes = propuestaString.split(",", -1);
        // Abre la ventana de Evaluación de Aval
        Usuario usuario = new Usuario(partes[0], "");
        usuario.setDatosDesdeTxt();
        Propuesta propuesta = new Propuesta(
            usuario, partes[2], partes[3], partes[4], 
            partes[5], partes[6], partes[7], (partes[8]), 
            partes[9], partes[10], partes[11]);
        return propuesta;
    }
}