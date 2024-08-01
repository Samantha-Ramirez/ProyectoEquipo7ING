package main.Model.gestionPropuesta;

import main.Model.gestionSesionUsuario.*;
import main.Model.gestionBases.Base;
import main.Model.gestionEvaluacionAval.AvalTecnico;

import java.util.List;

public class Propuesta extends Base {
    private Usuario usuario; //proponente
    private String estado;
    private String nombre;
    private String unidadResponsableDeTramite; //DEU, CEF --consejo,comision--
    private String denominacion;
    private String fundamentacion;
    private String duracion;
    private String pathPerfilParticipantes;
    private String pathPerfilDocente;
    private String pathCurriculoCompetencias;
    private String pathEstrategiasEvaluacion;
    private String pathExigenciasMaterialesYServicios;
    private AvalTecnico aval;
    
    public Propuesta (
        Usuario usuario, String nombre, String unidadResponsableDeTramite, 
        String denominacion, String duracion, String fundamentacion,
        String pathPerfilParticipantes, String pathPerfilDocente, 
        String pathCurriculoCompetencias, String pathEstrategiasEvaluacion, 
        String pathExigenciasMaterialesYServicios
        ){
        this.aval = new AvalTecnico();
        this.usuario = usuario;
        this.estado = this.aval.getEstado();
        this.nombre = nombre;
        this.unidadResponsableDeTramite = unidadResponsableDeTramite;
        this.denominacion = denominacion;
        this.duracion = duracion;
        this.fundamentacion = fundamentacion;
        this.pathPerfilParticipantes = pathPerfilParticipantes;
        this.pathPerfilDocente = pathPerfilDocente;
        this.pathCurriculoCompetencias = pathCurriculoCompetencias;
        this.pathEstrategiasEvaluacion = pathEstrategiasEvaluacion;
        this.pathExigenciasMaterialesYServicios = pathExigenciasMaterialesYServicios;
        
        if (esCreacionValida())
            guardarPropuesta();
    }
    
    public String[] getDatos (){
        String[] datos = {this.usuario.getNombreUsuario(), this.estado, this.nombre, this.unidadResponsableDeTramite, this.denominacion, this.duracion, this.fundamentacion, 
            this.pathPerfilParticipantes, this.pathPerfilDocente, 
            this.pathCurriculoCompetencias, this.pathEstrategiasEvaluacion,
            this.pathExigenciasMaterialesYServicios};
        return datos;
    }

    public String getNombre(){
        return nombre;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public Boolean esCreacionValida(){
        List<String> datos = leerDatos("Propuesta.txt");
        int creaciones = 0;
        for(int i = 0; i<datos.size(); i++){
            String[] nombres = datos.get(i).split("[,]", 0);
            if (nombres[0]==this.nombre)
                creaciones++;
        }
        if(creaciones >= 3)
            return false;
        return true;
    }
    
    public void guardarPropuesta(){
        guardarDatos("Propuesta.txt", getDatos(), ",", true);
    }

    public void actualizarDatos(){
        actualizarDatos("Propuesta.txt", getDatos(), ",", this.nombre);
    }

    public void setEstado(String estado){//aprobado, rechazado, enEvaluacion
        this.estado = estado;
        this.aval.setEstado(estado);
        this.aval.actualizarDatos();
    }
    
    public void setEstado(String estado, String observaciones){//aprobado, rechazado, enEvaluacion
        this.aval.setObservaciones(observaciones);
        setEstado(estado);
    }

    public void aprobarAvalPropuesta(){
        this.setEstado("aprobado");
        this.usuario.setTipoUsuario("Aliado");
    }
}