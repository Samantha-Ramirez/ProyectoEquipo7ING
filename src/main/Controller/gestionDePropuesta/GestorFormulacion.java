package main.Controller.gestionDePropuesta;

import main.View.abstractas.VistaError;
import main.Model.gestionDePropuesta.*;
import main.View.gestionDePropuesta.*;
import main.Model.gestionDeSesionUsuario.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

        public void guardarUploads(String[] uploads){
            for(int i = 0; i<uploads.length; i++){
                String filePath = uploads[i];  
                if (!filePath.isEmpty()) {  
                    File file = new File(filePath);  
                    String destinationPath = "uploads/" + file.getName();  
                    try {  
                        // Crear el directorio de uploads si no existe  
                        Files.createDirectories(Paths.get("uploads"));  
                        // Copiar el archivo al directorio de uploads  
                        try (FileInputStream inStream = new FileInputStream(file);  
                                FileOutputStream outStream = new FileOutputStream(destinationPath)) {  
                            byte[] buffer = new byte[1024];  
                            int bytesRead;  
                            while ((bytesRead = inStream.read(buffer)) != -1) {  
                                outStream.write(buffer, 0, bytesRead);  
                            }  
                        }  
                        
                    } catch (IOException ioException) {  
                    }  
                }
            }
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
            formCargaCurso.getPathPerfilParticipantes(), 
            formCargaCurso.getPathPerfilDocente(),
            formCargaCurso.getPathCurriculoCompetencias(),
            formCargaCurso.getPathEstrategiasEvaluacion(),
            formCargaCurso.getPathExigenciasMaterialesYServicios()
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