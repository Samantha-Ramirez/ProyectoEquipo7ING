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

    public boolean registrarDatos() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String currentTime = LocalDateTime.now().format(dtf);
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)

        String registroHoraFileName = basePath + nombreUsuario + "_registroHora.txt";//concatenacion del nombre del archivo de registro de Inicio y fin de sesion
        String usuarioFileName = basePath + nombreUsuario + ".txt";//
        archivoRegistroDeHora = registroHoraFileName;// asignando nombre de archivo donde estara el registro de entrada, para usar cuando se vaya a cerrar sesion
        if (!Files.exists(Paths.get(usuarioFileName))) {// verifica si el archivo de usuario existe, en caso de que exista retorna falso, pues ese usuario ya esta registrado
            try (FileWriter registroHoraWriter = new FileWriter(registroHoraFileName);
                 FileWriter usuarioWriter = new FileWriter(usuarioFileName)) { // abre el arcihivo en modo lectura

                // Escribe la hora actual en el archivo de registro de hora
                registroHoraWriter.write("Fecha de Inicio: " + currentTime + "\n");

                // Escribe los datos del usuario en el archivo del usuario
                usuarioWriter.write( tipoUsuario + "\n");
                usuarioWriter.write(clave + "\n");
                usuarioWriter.write( registroHoraFileName + "\n");

            } catch (IOException e) {
                e.printStackTrace(); // manejo de excepciones con respecto a las entradas
            }
            return true;
        }else{
            // MOSTRAR MENSAJE DE ERROR :
            return false;
        }

    }

    public Propuesta crearPropuesta(int userId, int estado){
        Propuesta propuesta = new Propuesta();
        return propuesta;
    }
    public void setEstado(int estado){

    }
}