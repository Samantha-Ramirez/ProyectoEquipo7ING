package main.Model.gestionDePropuesta;

// Importaciones necesarias para el manejo de archivos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Propuesta {
    private enum Estado{
        aprobado,
        rechazado,
        enProceso
    }
    private String nombre;
    private String unidadResponsableDeTramite;
    private String denominacion;
    private String fundamentacion;
    private String duracion;
    private String archivofundamentacion;
    private String archivoperfilParticipantes;
    private String archivoperfilDocente;
    private String archivocurriculoCompetencias;
    private String archivoestrategiasEvaluacion;
    private String archivoexigenciasMaterialesYServicios;
    
    public Propuesta (String nombre, String unidadResponsableDeTramite, String denominacion, String duracion, String fundamentacion){
        this.unidadResponsableDeTramite = unidadResponsableDeTramite;
        this.denominacion = denominacion;
        this.duracion = duracion;
        this.fundamentacion = fundamentacion;
    }

    public Boolean esCreacionValida(){
        //guardar en txt
        return true;
    }

    public void setEstado(int estado){

    }
}