package main.Model.gestionEvaluacionAval;

import main.Model.gestionBases.Base;
import main.Model.gestionPropuesta.*;

public class AvalTecnico extends Base {
    private Propuesta propuesta; //smellcode
    private String estado; //aprobado, rechazado, enEvaluacion
    private String observaciones;

    public AvalTecnico(Propuesta propuesta){
        this.estado = "en evaluacion";
        this.propuesta = propuesta;
        this.observaciones = "";
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    // obtener array con todos los datos que se deben actualizar en el txt
    public String[] getDatos (){
        String[] datos = {
            this.propuesta.getNombre(),
            this.estado,
            this.observaciones,};
        return datos;
    }

    public void guardarAval(){
        guardarDatos("Aval.txt", getDatos(), ",", true);
    }

    public void actualizarDatos(){
        String nombreArch = "Aval.txt";
        actualizarDatos(nombreArch, getDatos(), ",", this.propuesta.getNombre());
    }
}
