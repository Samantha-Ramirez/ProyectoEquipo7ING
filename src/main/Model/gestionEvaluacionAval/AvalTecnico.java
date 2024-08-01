package main.Model.gestionEvaluacionAval;

public class AvalTecnico {
    private String estado; //aprobado, rechazado, enEvaluacion
    public AvalTecnico(){
        this.estado = "enEvaluacion";
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
        //guardar en txt
    }
}
