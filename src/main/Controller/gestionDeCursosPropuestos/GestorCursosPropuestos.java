package main.Controller.gestionDeCursosPropuestos;

import main.Model.gestionDeCursosPropuestos.CursoExtension;
import main.Model.gestionDeSesionUsuario.Usuario;
import main.View.gestionDeCursosPropuestos.VistaCursosPropuestos;
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
