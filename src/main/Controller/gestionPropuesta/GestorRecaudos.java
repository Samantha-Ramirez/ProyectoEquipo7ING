package main.Controller.gestionPropuesta;

import main.View.gestionPropuesta.*;
import main.Model.gestionSesionUsuario.Usuario;
// importar base
import main.Controller.gestionBases.*;

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
            // guardar archivos
            String[] uploads = {
                formRegistroRecaudos.getPathISLR(), 
                formRegistroRecaudos.getPathCurriculum(),
                formRegistroRecaudos.getPathTitulo(),
                formRegistroRecaudos.getPathRegistroMercantil()
            };
            guardarUploads(uploads);

            // setear y actualizar en txt los datos de usuario
            this.usuario.setDatos(
                formRegistroRecaudos.getPersona(), formRegistroRecaudos.getRIF(), 
                formRegistroRecaudos.getCI(), formRegistroRecaudos.getEsComunidad(),
                getPathNombre(formRegistroRecaudos.getPathISLR()), 
                getPathNombre(formRegistroRecaudos.getPathCurriculum()),
                getPathNombre(formRegistroRecaudos.getPathTitulo()),
                getPathNombre(formRegistroRecaudos.getPathRegistroMercantil())
            );
            this.usuario.actualizarDatos();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!formRegistroRecaudos.esDatosRecaudosCompletos()){
                this.error = new VistaError("Debe completar");
            }else{
                // si todo esta correcto guardar e ir a carga de formulacion
                guardarDatosRecaudos();
                formRegistroRecaudos.setVisible(false);
                new GestorFormulacion(usuario);
            }
        }
}