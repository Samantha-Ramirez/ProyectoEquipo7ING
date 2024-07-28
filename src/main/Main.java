package main;


import main.Controller.gestionDeSesionUsuario.GestorDeSesion;
import main.Model.gestionDeSesionUsuario.Usuario;
import main.View.gestionDeSesionUsuario.VistaInicioSesion;
import main.View.gestionDeSesionUsuario.VistaRegistro;
import main.View.gestionDeSesionUsuario.VistaDashboard;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // se ejecuta primero este metodo
        // static porque no tiene que crear un objeto para ser usad
        VistaRegistro vistaRegistro = new VistaRegistro();
        vistaRegistro.setVisible(false);
        VistaDashboard vistaDashboard = new VistaDashboard();
        VistaInicioSesion vistaInicioSesion = new VistaInicioSesion();
        new GestorDeSesion(vistaInicioSesion, vistaRegistro, vistaDashboard);
        //new GestorDeSesion(vistaInicioSesion, vistaRegistro);


    }
}
