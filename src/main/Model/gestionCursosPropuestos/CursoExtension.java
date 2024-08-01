package main.Model.gestionCursosPropuestos;

import main.Model.gestionSesionUsuario.Usuario;
// importar base
import main.Model.gestionBases.Base;

public class CursoExtension extends Base {
    // private Usuario usuario; se decide ligar al proponente con la propuesta 
    // y no con el curso como se habia pensado inicialmente en el diagrama de clases del modelo de dominio
    private Usuario usuario;
    private String areaConocimiento;
    private String modalidad;
    private String tipoCurso;
    private float ingresosNetos;

    public CursoExtension (Usuario usuario){
        // this.propuesta = propuesta; FIX:curso asociado a propuesta
        this.usuario = usuario;
        this.areaConocimiento = "Ciencias";
        this.modalidad = "online";
        this.tipoCurso = "curso";
        this.ingresosNetos = 0;
    }

    public String getNombreUsuario() { return usuario.getNombreUsuario();}
    // public Vector<String> getCursosPropuestos() {return cursosPropuestos;}

    public String[] getDatos (){
        String[] datos = {
            this.usuario.getNombreUsuario(), 
            this.areaConocimiento,
            this.modalidad,
            this.tipoCurso,
            String.valueOf(this.ingresosNetos)};
        return datos;
    }

    public void guardarCurso(){
        guardarDatos("CursoExtension.txt", getDatos(), ",", true);
    }

}
