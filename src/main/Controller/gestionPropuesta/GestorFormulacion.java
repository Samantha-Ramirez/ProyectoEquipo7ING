package main.Controller.gestionPropuesta;

import main.View.gestionPropuesta.*;
import main.Model.gestionPropuesta.*;
import main.Controller.gestionBases.GestorBase;
import main.Controller.gestionBases.VistaError;
import main.Model.gestionSesionUsuario.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorFormulacion extends GestorBase {

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
            
            String[] uploads = {
                formCargaCurso.getPathPerfilParticipantes(), 
                formCargaCurso.getPathPerfilDocente(),
                formCargaCurso.getPathCurriculoCompetencias(),
                formCargaCurso.getPathEstrategiasEvaluacion(),
                formCargaCurso.getPathExigenciasMaterialesYServicios()
            };

            guardarUploads(uploads);

            this.propuesta = new Propuesta(
            this.usuario, 
            formCargaCurso.getNombre(), 
            formCargaCurso.getUnidadResponsableDeTramite(), 
            formCargaCurso.getDenominacion(), 
            formCargaCurso.getDuracion(), 
            formCargaCurso.getFundamentacion(),
            getPathNombre(formCargaCurso.getPathPerfilParticipantes()), 
            getPathNombre(formCargaCurso.getPathPerfilDocente()),
            getPathNombre(formCargaCurso.getPathCurriculoCompetencias()),
            getPathNombre(formCargaCurso.getPathEstrategiasEvaluacion()),
            getPathNombre(formCargaCurso.getPathExigenciasMaterialesYServicios())
            );
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