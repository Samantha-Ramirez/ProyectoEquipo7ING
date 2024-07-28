package main.Model.gestionDePropuesta;

public class Propuesta {
    private enum Estado{
        aprobado,
        rechazado,
        enProceso
    }
    private String unidadResponsableDeTramite;
    private String denominacion;
    private String objetivos;
    private String fundamentacion;
    private String perfilParticipantes;
    private String perfilDocente;
    private String curriculoCompetencias;
    private String estrategiasEvaluacion;
    private String exigenciasMaterialesYServicios;
    private String duracion;

    public void actualizarDatos(/*datos */ int userId){

    }
    public Propuesta crearPropuesta(int userId, int estado){
        Propuesta propuesta = new Propuesta();
        return propuesta;
    }
    public void setEstado(int estado){

    }
}