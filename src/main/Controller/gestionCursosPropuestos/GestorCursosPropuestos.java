package main.Controller.gestionCursosPropuestos;

import main.View.gestionCursosPropuestos.*;
import main.Model.gestionPropuesta.*;
import main.Model.gestionSesionUsuario.Usuario;

import java.util.Vector;

public class GestorCursosPropuestos {
    //Atributos
    private Usuario usuario;
    private Vector<String> cursosPropuestos;
    private VistaCursosPropuestos vistaCursosPropuestos;
    // Constructor
    public GestorCursosPropuestos(Usuario usuario){
        this.usuario = usuario;
        this.cursosPropuestos = new Vector<>();

        // Busca la informacion de los cursos
        Propuesta propuesta = new Propuesta(usuario);
        // guarda la informacion de los cursos
        cursosPropuestos = propuesta.getPropuestas(true, false);
        // muestra la interfaz con la informacion extraida
        this.vistaCursosPropuestos = new VistaCursosPropuestos(cursosPropuestos);
        if(cursosPropuestos.size()>0){
            vistaCursosPropuestos.setVisible(true);
        }else{
            vistaCursosPropuestos.mostrarMensaje("No hay cursos");
        }
    }
}
