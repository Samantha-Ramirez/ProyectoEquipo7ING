package main.Controller.gestionEvaluacionAval;

import main.View.gestionEvaluacionAval.VistaPropuestasEvaluar;
import main.Model.gestionPropuesta.Propuesta;

import java.util.Vector;

public class GestorPropuestasEvaluar {
    //Atributos
    private Vector<String> propuestas;
    // Constructor
    public GestorPropuestasEvaluar(){
        this.propuestas = new Vector<>();
    }

    public void mostrarPropuestas(){
        // Busca la informacion de los cursos
        Propuesta propuesta = new Propuesta("");
        // guarda la informacion de los cursos
        propuestas = propuesta.getPropuestas(false, true);
        // muestra la interfaz con la informacion extraida
        VistaPropuestasEvaluar vistaPropuestasEvaluar = new VistaPropuestasEvaluar(propuestas);
        vistaPropuestasEvaluar.setVisible(true);
    }
}
