package main.Controller.gestionDePropuesta;

import main.View.abstractas.VistaError;
import main.View.gestionDePropuesta.*;
import main.Model.gestionDeSesionUsuario.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorRecaudos implements ActionListener {

        // instancias de las clases que vista y modelo
        private FormularioRegistroRecaudos formRegistroRecaudos;
        private VistaError error;
        private Usuario usuario;
        //private Propuesta propuesta;

        // constructor deL controlador
        public GestorRecaudos(Usuario usuario) {
           // Inicializacion de las instancias
            this.usuario = usuario;
            this.formRegistroRecaudos = new FormularioRegistroRecaudos();
            this.formRegistroRecaudos.setVisible(true);
            
            this.formRegistroRecaudos.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
        }

        public void guardarDatosRecaudos(){
            String nombre = formRegistroRecaudos.getNombre();
            String persona = formRegistroRecaudos.getPersona();
            String RIF = formRegistroRecaudos.getRIF();
            String CI = formRegistroRecaudos.getCI();
            String esComunidad = formRegistroRecaudos.getEsComunidad();
            this.usuario.actualizarDatos(nombre, persona, RIF, CI, esComunidad);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Retorna los datos que se ingresaron en la interfaz
            if(!formRegistroRecaudos.esDatosRecaudosCompletos()){
                this.error = new VistaError("Debe completar");
            }else{
                guardarDatosRecaudos();
                formRegistroRecaudos.setVisible(false);
                new GestorFormulacion(usuario);
            }
        }
}