package main.Model.gestionSesionUsuario;

import main.Model.gestionBases.Base;

// Importaciones necesarias para el manejo de fechas
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Usuario extends Base {
    // Atributos
    protected String nombreUsuario;
    protected String clave;
    protected String tipoUsuario; //Aliado, Proponente, Administrador//DEU, CEF --comision, consejo--
    protected String pathRegistroHora;

    protected String persona; //Normal, Juridica
    protected String RIF;
    protected String CI;
    protected String esComunidad;
    protected String pathISLR;
    protected String pathCurriculum;
    protected String pathTitulo;
    protected String pathRegistroMercantil;
    protected String pathExpediente;

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
    
    public boolean registrarDatos() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String currentTime = LocalDateTime.now().format(dtf);
        String registroHoraFileName = nombreUsuario + "_registroHora.txt";//concatenacion del nombre del archivo de registro de Inicio y fin de sesion
        String[] datosHora = {"Fecha de Inicio: " + currentTime};
        pathRegistroHora = registroHoraFileName; // asignando nombre de archivo donde estara el registro de entrada, para usar cuando se vaya a cerrar sesion
        guardarDatos(registroHoraFileName, datosHora, "\n", false);

        String usuarioFileName = nombreUsuario + ".txt";//
        String[] datosUsuario = {tipoUsuario, clave, registroHoraFileName};
        guardarDatos(usuarioFileName, datosUsuario, "\n", false);
        return true;

    }
    public void crearExpediente(){
        String[] datos = {};
        this.pathExpediente = nombreUsuario + "_expediente.txt";
        guardarDatos(pathExpediente, datos, "\n", false);
    }
    public void agregarAExpediente() {
        // verifica que exista el archivo antes de abrir el el archivo
        String[] datos = {};
        guardarDatos(pathExpediente, datos, "\n", true);
    }
    // Actualiza las fechas de inicio y fin de sesion
    public void agregarDatosRegistroDeHora(String fin_inicio) {
        // verifica que exista el archivo antes de abrir el el archivo
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String currentTime = LocalDateTime.now().format(dtf);
        String[] datos = {"Fecha de " + fin_inicio + ": " + currentTime};
        guardarDatos(pathRegistroHora, datos, "\n", true);
    }

    // revisa si los datos ingresados en el inicio de sesion son correctos
    public boolean verificarDatos() {
        // Direccion exacta donde debe estar el txt(data) del usuario solicitado
        String usuarioFileName = nombreUsuario + ".txt";
        List<String> datos = leerDatos(usuarioFileName, 3);
        if(datos.size() != 0){
            tipoUsuario = datos.get(0);
            String storedClave = datos.get(1);
            pathRegistroHora = datos.get(2);
            if(this.clave.equals(storedClave)){
                // si la clave es correcta entonces va a permtir actualizar el registro de fehca
                agregarDatosRegistroDeHora("Inicio");
                return true;
            }
        }
        return false;
    }
    
    public String[] getDatos (){
        String[] datos = {
            this.tipoUsuario, //Aliado, Proponente, Administrador//DEU, CEF --comision, consejo--
            this.clave,
            this.pathRegistroHora,
            this.persona,
            this.RIF, 
            this.CI, 
            this.esComunidad,
            this.pathISLR,
            this.pathCurriculum,
            this.pathTitulo,
            this.pathRegistroMercantil,
            this.pathExpediente,};
        return datos;
    }

    public void setDatos (
        String persona, String RIF, String CI, String esComunidad, 
        String pathISLR, String pathCurriculum, String pathTitulo, String pathRegistroMercantil){
        this.persona = persona;
        this.RIF = RIF;
        this.CI = CI;
        this.esComunidad = esComunidad;
        this.pathISLR = pathISLR;
        this.pathCurriculum = pathCurriculum;
        this.pathTitulo = pathTitulo;
        this.pathRegistroMercantil = pathRegistroMercantil;
    }

    public void actualizarDatos(){
        String nombreArch = this.getNombreUsuario() + ".txt";
        actualizarDatos(nombreArch, getDatos(), "\n");
    }

    public void setDatosDesdeTxt(){
        List<String> datos = leerDatos(this.nombreUsuario+".txt", 12);
        this.tipoUsuario = datos.get(0);
        this.clave = datos.get(1);
        this.pathRegistroHora = datos.get(2);
        setDatos(datos.get(3), datos.get(4), datos.get(5), 
        datos.get(6), datos.get(7), datos.get(8), datos.get(9), datos.get(10));
        this.pathExpediente = datos.get(11);
    }
}