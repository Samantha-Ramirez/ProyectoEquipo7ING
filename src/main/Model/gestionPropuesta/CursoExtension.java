package main.Model.gestionPropuesta;

import java.util.List;

import main.Model.gestionBases.Base;

public class CursoExtension extends Base {
    // private Usuario usuario; se decide ligar al proponente con la propuesta 
    // y no con el curso como se habia pensado inicialmente en el diagrama de clases del modelo de dominio
    private Propuesta propuesta;
    private String areaConocimiento;
    private String modalidad;
    private String tipoCurso;
    private float ingresosNetos;
    //FIX:atributos

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
            // this.usuario.getNombreUsuario(), 
            this.propuesta.getNombre(), 
            this.areaConocimiento,
            this.modalidad,
            this.tipoCurso,
            String.valueOf(this.ingresosNetos)};
        guardarDatos("CursoExtension.txt", datos, ",", true);
    }

}
