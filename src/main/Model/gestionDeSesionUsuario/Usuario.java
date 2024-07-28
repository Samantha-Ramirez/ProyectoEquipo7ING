package main.Model.gestionDeSesionUsuario;

// Importaciones necesarias para el manejo de archivos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// Importaciones necesarias para el manejo de fechas
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario {
    // Atributos
    private String nombreUsuario;
    private String clave;
    private String tipoUsuario;
    private String archivoRegistroDeHora;

    // Constructor de la clase Usuario, inicializa nombreUsuario y clave
    public Usuario (String nombreUsuario, String clave){
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        //this.tipoUsuario = tipoUsuario;
    }
    // Setter para el tipo de usuario
    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    // getter para el nombre de usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    // getter para el la clave
    public String getClave() {
        return clave;
    }
    // getter para el tipo de usuario
    public String getTipoUsuario(){
        return tipoUsuario;
    }
    // Método para verificar si los datos del usuario están completos, retorna falso en caso de que esten incompletos
    public boolean datosCompletos(){
        return !nombreUsuario.isEmpty() && !clave.isEmpty();
    }
    // Método para registrar los datos del usuario en archivos
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
    // Actualiza las fechas de inicio y fin de sesion
    public void agregarDatosRegistroDeHora(String fin_inicio) {
        // verifica que exista el archivo antes de abrir el el archivo
        if (Files.exists(Paths.get(archivoRegistroDeHora))) {
            // toma hora actual
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String currentTime = LocalDateTime.now().format(dtf);
            // abre el archivo en modo escritura y actualiza la fecha
            try (FileWriter usuarioWriter = new FileWriter(archivoRegistroDeHora, true)) { // 'true' habilita el modo de append
                usuarioWriter.write("Fecha de " + fin_inicio + ": " + currentTime + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    // revisa si los datos ingresados en el inicio de sesion son correctos
    public boolean verificarDatos() {
        // Direccion exacta donde debe estar el txt(data) del usuario solicitado
        String basePath = "src/main/Data/";
        String usuarioFileName = basePath + nombreUsuario + ".txt";
        // si el archivo no existe entonces retorna falso, ya que aun no se ha registrado
        if (!Files.exists(Paths.get(usuarioFileName))) {
            return false; // Retorna false si el archivo no existe
        }
        // abre el archivo en modo lectura
        try (BufferedReader reader = new BufferedReader(new FileReader(usuarioFileName))) {
            // Lee la primera línea (tipo de usuario)
            tipoUsuario = reader.readLine();
            // Lee la segunda línea (clave)
            String storedClave = reader.readLine();

            // Compara la clave leída con la clave del usuario
            if(this.clave.equals(storedClave)){
                // si la clave es correcta entonces va a permtir actualizar el registro de fehca
                archivoRegistroDeHora = reader.readLine();
                agregarDatosRegistroDeHora("Inicio");
                return true;
            }else{
                return false;
            }

        } catch (IOException e) {// manejo de excepcion
            e.printStackTrace();
            return false;
        }
    }

}



