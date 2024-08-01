package main.Controller.gestionCursosPropuestos;

import main.Model.gestionCursosPropuestos.Expediente;
import main.Model.gestionSesionUsuario.Usuario;
import main.View.gestionCursosPropuestos.VistaExpediente;
// importar base
import main.Controller.gestionBases.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorExpediente extends GestorBase {
        // instancias de las clases que vista y modelo
        private VistaExpediente vistaExpediente;
        private VistaError error;
        private Usuario usuario;
        private Expediente expediente;

        // constructor del controlador
        public GestorExpediente(Usuario usuario) {
           // Inicializacion de las instancias
            this.usuario = usuario;

            
            this.vistaExpediente = new VistaExpediente();
            // if(expediente.getCartasCompromiso().size()>0 && expediente.getCartasIntencion().size()>0){
                vistaExpediente.setVisible(true);
            // }else{
            //    vistaExpediente.mostrarMensaje("No hay cursos");
            // }
                        
            this.vistaExpediente.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
}