package main.Controller.gestionDePropuesta;

import main.View.abstractas.VistaError;
import main.Model.gestionDePropuesta.CursoExtension;
import main.Model.gestionDePropuesta.Propuesta;
import main.View.gestionDePropuesta.FormularioCargaCurso;
import main.Model.gestionDeSesionUsuario.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorFormulacion implements ActionListener {

        // instancias de las clases que vista y modelo
        private FormularioCargaCurso formCargaCurso;
        private VistaError error;
        private Usuario usuario;
        private Propuesta propuesta;
        
        //private Propuesta propuesta;

        // constructor deL controlador
        public GestorFormulacion(Usuario usuario) {
           // Inicializacion de las instancias
            this.usuario = usuario;
            this.formCargaCurso = new FormularioCargaCurso();
            this.formCargaCurso.setVisible(true);
            
            this.formCargaCurso.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
        }

        public void guardarFormulacion(){
            String nombre = formCargaCurso.getNombre();
            String unidadResponsableDeTramite = formCargaCurso.getUnidadResponsableDeTramite();
            String denominacion = formCargaCurso.getDenominacion();
            String duracion = formCargaCurso.getDuracion();
            String fundamentacion = formCargaCurso.getFundamentacion();
            this.propuesta = new Propuesta(this.usuario.nombreUsuario, nombre, unidadResponsableDeTramite, denominacion, duracion, fundamentacion);
            CursoExtension cursoExtension = new CursoExtension(this.propuesta);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Retorna los datos que se ingresaron en la interfaz
            if(!formCargaCurso.esDatosRecaudosCompletos()){
                this.error = new VistaError("Debe completar");
            }else{
                guardarFormulacion();
                formCargaCurso.setVisible(false);
            }
        }
}