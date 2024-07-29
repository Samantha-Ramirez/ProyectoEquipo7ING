package main;

import main.Controller.gestionDeSesionUsuario.*;
import main.Model.gestionDeCursosPropuestos.CursoExtension;
import main.View.gestionDeSesionUsuario.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        VistaRegistro vistaRegistro = new VistaRegistro();
        vistaRegistro.setVisible(false);
        VistaDashboard vistaDashboard = new VistaDashboard();
        VistaInicioSesion vistaInicioSesion = new VistaInicioSesion();
        
        new GestorDeSesion(vistaInicioSesion, vistaRegistro, vistaDashboard);


    }
}
