package main.Model.gestionPropuesta;

import main.Model.gestionSesionUsuario.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CursoExtension extends Abstracta {
    // private Usuario usuario; se decide ligar al proponente con la propuesta 
    // y no con el curso como se habia pensado inicialmente en el diagrama de clases del modelo de dominio
    private Propuesta propuesta;
    private String areaConocimiento;
    private String modalidad;
    private String tipoCurso;
    private float ingresosNetos;

    public CursoExtension (Propuesta propuesta){
        this.propuesta = propuesta;
        this.areaConocimiento = "Ciencias";
        this.modalidad = "online";
        this.tipoCurso = "curso";
        this.ingresosNetos = 0;
        guardarCurso();
    }

    public void guardarCurso(){
        String[] datos = {
            this.usuario.getNombreUsuario(), 
            this.propuesta.getNombre(), 
            this.areaConocimiento,
            this.modalidad,
            this.tipoCurso,
            String.valueOf(this.ingresosNetos)};
        guardarDatos("CursoExtension.txt", datos, ",", true);
    }
}
