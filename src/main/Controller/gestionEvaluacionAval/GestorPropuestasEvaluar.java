package main.Controller.gestionEvaluacionAval;

import main.View.gestionEvaluacionAval.VistaPropuestasEvaluar;
import main.Model.gestionPropuesta.Propuesta;
// importar base
import main.Controller.gestionBases.GestorBase;

import java.util.Vector;

public class GestorPropuestasEvaluar extends GestorBase {
    //Atributos
    private Vector<String> propuestas;
    // Constructor
    public GestorPropuestasEvaluar(){
        this.propuestas = new Vector<>();
    }

    public void mostrarPropuestas(){
        // Busca la informacion de los cursos
        Propuesta propuesta = new Propuesta();
        // guarda la informacion de los cursos
        propuestas = propuesta.getPropuestas();
        // muestra la interfaz con la informacion extraida
        VistaPropuestasEvaluar vistaPropuestasEvaluar = new VistaPropuestasEvaluar(propuestas);
        vistaPropuestasEvaluar.setVisible(true);
    }
}
