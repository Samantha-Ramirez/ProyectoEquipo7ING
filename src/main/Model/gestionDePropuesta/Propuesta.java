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
    private String usuario;

    private String estado; //aprobado, rechazado, enProceso
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
    
    public Propuesta (String usuario, String nombre, String unidadResponsableDeTramite, String denominacion, String duracion, String fundamentacion){
        this.usuario = usuario;
        this.unidadResponsableDeTramite = unidadResponsableDeTramite;
        this.denominacion = denominacion;
        this.duracion = duracion;
        this.fundamentacion = fundamentacion;
        guardarPropuesta();
    }

    public Boolean esCreacionValida(){
        //guardar en txt
        return true;
    }
    public void guardarPropuesta(){
        String nombreArch = "src/main/Data/Propuesta.txt";
        String[] datos = {
            this.usuario, 
            this.estado,
            this.nombre, 
            this.unidadResponsableDeTramite, 
            this.denominacion, 
            this.fundamentacion, 
            this.duracion, 
            this.archivofundamentacion, 
            this.archivoperfilParticipantes, 
            this.archivoperfilDocente, 
            this.archivocurriculoCompetencias, 
            this.archivoestrategiasEvaluacion, 
            this.archivoexigenciasMaterialesYServicios};
        // verifica que exista el archivo antes de abrir el el archivo
        if (Files.exists(Paths.get(nombreArch))) {

            // abre el archivo en modo escritura
            try (FileWriter usuarioWriter = new FileWriter(nombreArch, true)) { // 'true' habilita el modo de append
                for(int i = 0; i<datos.length; i++){
                    usuarioWriter.write(datos[i] + ",");
                }
                usuarioWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setestado(int estado){

    }
}