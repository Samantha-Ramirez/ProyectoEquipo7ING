package main.Model.gestionEvaluacionAval;

import main.Model.gestionBases.Base;
import main.Model.gestionPropuesta.*;

public class AvalTecnico extends Base {
    private Propuesta propuesta; //FIX:smellcode
    private String estado; //aprobado, rechazado, enEvaluacion
    private String observaciones;

    public AvalTecnico(){
        this.estado = "enEvaluacion";
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
        //FIX:guardar en txt
    }
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
        //FIX:guardar en txt
    }
    public String[] getDatos (){
        String[] datos = {
            this.propuesta.getNombre(),
            this.estado,
            this.observaciones,};
        return datos;
    }

    public void actualizarDatos(){
        String nombreArch = "Aval.txt";
        actualizarDatos(nombreArch, getDatos(), "\n", this.propuesta.getNombre());
    }
}
