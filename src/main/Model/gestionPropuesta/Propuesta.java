package main.Model.gestionPropuesta;

import main.Model.gestionSesionUsuario.*;
import main.Model.gestionCursosPropuestos.CursoExtension;
import main.Model.gestionEvaluacionAval.AvalTecnico;
// importar base
import main.Model.gestionBases.Base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

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
    
    public Propuesta (){}

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
    }
    
    // obtener array con todos los datos que se deben actualizar en el txt
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

    // verificar si la propuesta ya ha sido hecha +3 veces
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
    
    // guardar propuesta en txt
    public void guardarPropuesta(){
        if (esCreacionValida())
            guardarDatos("Propuesta.txt", getDatos(), ",", true);
    }

    // actualizar datos en txt
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

    // cambiar estado a aprobado y cambiar de proponente a aliado
    public void aprobarAvalPropuesta(){
        this.setEstado("aprobado");
        this.usuario.setTipoUsuario("Aliado");
        //FIX:crear curso al aprobar
        //new CursoExtension(this);
    }
    public void rechazarAvalPropuesta(String observaciones){
        this.setEstado("rechazado", observaciones);
    }

    // obtener propuestas correspondientes a un usuario
    public Vector<String> getPropuestas(){
        List<String> datos = leerDatos("Propuesta.txt");
        Vector<String> propuestas = new Vector<>();
        if(datos.size() != 0){
            for(int i = 0; i<datos.size(); i++){
                String[] dato = datos.get(i).split("[,]", 0);
                // Propuesta propuesta = new Propuesta(dato[0], dato[1], 
                // dato[2], dato[3], dato[4], dato[5], dato[6], dato[7],
                // dato[8], dato[9], dato[10])
                // getPropuesta(Nombre);
                if (dato[0].equals(this.usuario.getNombreUsuario())) {
                    propuestas.add(datos.get(i));
                }
            }
        }
        return propuestas;
    }
}