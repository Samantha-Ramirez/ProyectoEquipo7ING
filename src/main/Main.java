package main;

import main.Controller.gestionSesionUsuario.*;
import main.View.gestionSesionUsuario.*;

public class Main {
    public static void main(String[] args) {
        VistaRegistro vistaRegistro = new VistaRegistro();
        vistaRegistro.setVisible(false);
        VistaDashboard vistaDashboard = new VistaDashboard();
        VistaInicioSesion vistaInicioSesion = new VistaInicioSesion();
        
        new GestorDeSesion(vistaInicioSesion, vistaRegistro, vistaDashboard);

    }
}
