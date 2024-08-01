package main.Controller.gestionPropuesta;

import main.View.gestionPropuesta.*;
import main.Controller.gestionBases.*;
import main.Model.gestionSesionUsuario.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorRecaudos extends GestorBase {
        // instancias de las clases que vista y modelo
        private FormularioRegistroRecaudos formRegistroRecaudos;
        private VistaError error;
        private Usuario usuario;

        // constructor del controlador
        public GestorRecaudos(Usuario usuario) {
           // Inicializacion de las instancias
            this.usuario = usuario;
            this.formRegistroRecaudos = new FormularioRegistroRecaudos();
            this.formRegistroRecaudos.setVisible(true);
            
            this.formRegistroRecaudos.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
        }

        public void guardarDatosRecaudos(){
            String[] uploads = {
                formRegistroRecaudos.getPathISLR(), 
                formRegistroRecaudos.getPathCurriculum(),
                formRegistroRecaudos.getPathTitulo(),
                formRegistroRecaudos.getPathRegistroMercantil()
            };
            guardarUploads(uploads);

            this.usuario.setDatos(
                formRegistroRecaudos.getPersona(), formRegistroRecaudos.getRIF(), 
                formRegistroRecaudos.getCI(), formRegistroRecaudos.getEsComunidad(),
                getPathNombre(formRegistroRecaudos.getPathISLR()), 
                getPathNombre(formRegistroRecaudos.getPathCurriculum()),
                getPathNombre(formRegistroRecaudos.getPathTitulo()),
                getPathNombre(formRegistroRecaudos.getPathRegistroMercantil())
            );
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