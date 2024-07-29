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

import main.View.abstractas.JText;

public class Propuesta {
    private String usuario;

    private String estado; //aprobado, rechazado, enProceso
    private String nombre;
    private String unidadResponsableDeTramite;
    private String denominacion;
    private String fundamentacion;
    private String duracion;
    private String pathFundamentacion;
    private String pathPerfilParticipantes;
    private String pathPerfilDocente;
    private String pathCurriculoCompetencias;
    private String pathEstrategiasEvaluacion;
    private String pathExigenciasMaterialesYServicios;
    
    public Propuesta (
        String usuario, String nombre, String unidadResponsableDeTramite, 
        String denominacion, String duracion, String fundamentacion,
        String pathPerfilParticipantes, String pathPerfilDocente, 
        String pathCurriculoCompetencias, String pathEstrategiasEvaluacion, 
        String pathExigenciasMaterialesYServicios
        ){
        this.usuario = usuario;
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

    public Boolean esCreacionValida(){
        int creaciones = 0;
        // Direccion exacta donde debe estar el txt(data) del usuario solicitado
        String nombreArch = "src/main/Data/Propuesta.txt";
        // si el archivo no existe entonces retorna falso, ya que aun no se ha registrado
        // abre el archivo en modo lectura
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArch))) {  
            String line;  
            while ((line = br.readLine()) != null) {  
                
                String[] data = line.split("[,]", 0);
                if (data[0]==this.nombre)
                    creaciones++;

            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        if(creaciones >= 3)
            return false;
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
            this.pathPerfilParticipantes, 
            this.pathPerfilDocente, 
            this.pathCurriculoCompetencias, 
            this.pathEstrategiasEvaluacion, 
            this.pathExigenciasMaterialesYServicios};
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