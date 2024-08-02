package main.Controller.gestionCursosPropuestos;

import main.Model.gestionCursosPropuestos.Expediente;
import main.View.gestionCursosPropuestos.VistaExpediente;
import main.Model.gestionSesionUsuario.Usuario;
// importar base
import main.Controller.gestionBases.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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
            this.expediente = new Expediente(usuario);

            Vector<String> cartas = expediente.getCartas();
            this.vistaExpediente = new VistaExpediente(cartas); //FIX: empty
            if(cartas.size()>0){
                vistaExpediente.setVisible(true);
            }else{
                vistaExpediente.mostrarMensaje("No hay cartas");
            }
                        
            this.vistaExpediente.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            String path = "";
            if(comando.contains("ABRIR")){
                String[] partes = comando.split(":");
                comando = partes[0];
                path = partes[1];
            }
            switch (comando) {
                case "ABRIR":
                    openPDF(path);
                break;
                case "FIRMAR":
                    vistaExpediente.mostrarMensaje("Firmada");
                break;
                case "RECHAZAR":
                    vistaExpediente.mostrarMensaje("Rechazada");
                break;
            }                
        }
}