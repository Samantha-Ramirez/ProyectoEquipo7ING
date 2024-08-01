package main.Model.gestionSesionUsuario;

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
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos
    private String nombreUsuario;
    private String clave;
    private String tipoUsuario; //Aliado, Proponente, Administrador
    private String archivoRegistroDeHora;
    private String persona; //normal, juridica
    private String RIF;
    private String CI;
    private String esComunidad;
    private String pathISLR;
    private String pathCurriculum;
    private String pathTitulo;
    private String pathRegistroMercantil;

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
    public void guardarDatos(String fileName, String[] datos, String sep, Boolean type){
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)
        fileName = basePath + fileName;
        if ((!type && !Files.exists(Paths.get(fileName)) || type && Files.exists(Paths.get(fileName)))) {// verifica si el archivo de usuario existe, en caso de que exista retorna falso, pues ese usuario ya esta registrado
            try (FileWriter writer = new FileWriter(fileName, type)) { // abre el arcihivo en modo lectura // 'true' habilita el modo de append
                for(int i = 0; i<datos.length; i++){
                    writer.write(datos[i] + sep);
                }
            } catch (IOException e) {
                e.printStackTrace(); // manejo de excepciones con respecto a las entradas
            }
        }
    }
    
    public boolean registrarDatos() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String currentTime = LocalDateTime.now().format(dtf);
        String registroHoraFileName = nombreUsuario + "_registroHora.txt";//concatenacion del nombre del archivo de registro de Inicio y fin de sesion
        String[] datosHora = {"Fecha de Inicio: " + currentTime};
        archivoRegistroDeHora = registroHoraFileName; // asignando nombre de archivo donde estara el registro de entrada, para usar cuando se vaya a cerrar sesion
        guardarDatos(registroHoraFileName, datosHora, "\n", false);

        String usuarioFileName = nombreUsuario + ".txt";//
        String[] datosUsuario = {tipoUsuario, clave, registroHoraFileName};
        guardarDatos(usuarioFileName, datosUsuario, "\n", false);
        return true;

    }
    // Actualiza las fechas de inicio y fin de sesion
    public void agregarDatosRegistroDeHora(String fin_inicio) {
        // verifica que exista el archivo antes de abrir el el archivo
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String currentTime = LocalDateTime.now().format(dtf);
        String[] datos = {"Fecha de " + fin_inicio + ": " + currentTime};
        guardarDatos(archivoRegistroDeHora, datos, "\n", true);
    }

    public List<String> leerDatos(String fileName, int n){
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)
        fileName = basePath + fileName;
        List<String> datos = new ArrayList<String>();
        if (!Files.exists(Paths.get(fileName))) {
            return datos; // Retorna false si el archivo no existe
        }
        // abre el archivo en modo lectura
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for(int i = 0; i<n; i++){
                datos.add(reader.readLine());
            }
            return datos;

        } catch (IOException e) {// manejo de excepcion
            e.printStackTrace();
            return datos;
        }
    }
    // revisa si los datos ingresados en el inicio de sesion son correctos
    public boolean verificarDatos() {
        // Direccion exacta donde debe estar el txt(data) del usuario solicitado
        String usuarioFileName = nombreUsuario + ".txt";
        List<String> datos = leerDatos(usuarioFileName, 3);
        if(datos.size() != 0){
            tipoUsuario = datos.get(0);
            String storedClave = datos.get(1);
            archivoRegistroDeHora = datos.get(2);
            if(this.clave.equals(storedClave)){
                // si la clave es correcta entonces va a permtir actualizar el registro de fehca
                agregarDatosRegistroDeHora("Inicio");
                return true;
            }
        }
        return false;
    }

    public void actualizarDatos(
        String nombreUsuario, String persona, String RIF, 
        String CI, String esComunidad,
        String pathISLR, String pathCurriculum,
        String pathTitulo, String pathRegistroMercantil){
        this.persona = persona;
        this.RIF = RIF;
        this.CI = CI;
        this.esComunidad = esComunidad;
        this.pathISLR = pathISLR;
        this.pathCurriculum = pathCurriculum;
        this.pathTitulo = pathTitulo;
        this.pathRegistroMercantil = pathRegistroMercantil;
        
        String nombreArch = this.nombreUsuario + ".txt";
        String[] datos = {
            this.persona,
            this.RIF, 
            this.CI, 
            this.esComunidad,
            this.pathISLR,
            this.pathCurriculum,
            this.pathTitulo,
            this.pathRegistroMercantil,
        };
        guardarDatos(nombreArch, datos, "\n", true);
    }
}