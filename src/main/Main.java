package main;

import main.Controller.gestionSesionUsuario.*;
import main.Model.gestionCursosPropuestos.CursoExtension;
import main.View.gestionSesionUsuario.*;

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
