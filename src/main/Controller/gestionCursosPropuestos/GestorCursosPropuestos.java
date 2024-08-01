package main.Controller.gestionCursosPropuestos;

import main.Model.gestionCursosPropuestos.CursoExtension;
import main.Model.gestionSesionUsuario.Usuario;
import main.View.gestionCursosPropuestos.VistaCursosPropuestos;

import java.util.Vector;

public class GestorCursosPropuestos {
    //Atributos
    private String nombreUsuario;
    private Vector<String> cursosPropuestos;
    // Constructor
    public GestorCursosPropuestos(Usuario nombreUsuario){
        this.nombreUsuario = nombreUsuario.getNombreUsuario();
        this.cursosPropuestos = new Vector<>();
    }

    public void mostrarCursosPropuestos(){
        // Busca la informacion de los cursos
        CursoExtension curso = new CursoExtension(nombreUsuario);
        curso.leerArchivoPropuestas();
        // guarda la informacion de los cursos
        cursosPropuestos = curso.getCursosPropuestos();
        // muestra la interfaz con la informacion extraida
        VistaCursosPropuestos vista = new VistaCursosPropuestos(cursosPropuestos);
        vista.setVisible(true);
    }
}
