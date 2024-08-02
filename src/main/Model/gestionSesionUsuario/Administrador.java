package main.Model.gestionSesionUsuario;

public class Administrador extends Usuario {
    protected String tipoAdmin; //DEU, CEF
    public Administrador (String nombreUsuario, String clave){
        super(nombreUsuario, clave);
    }
}
