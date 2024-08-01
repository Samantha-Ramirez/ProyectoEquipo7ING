package main.Controller.gestionPropuesta;

import main.View.gestionPropuesta.*;
import main.Controller.gestionBases.VistaError;
import main.Model.gestionSesionUsuario.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

        public void guardarDatosRecaudos(){
            String[] uploads = {
                formRegistroRecaudos.getPathISLR(), 
                formRegistroRecaudos.getPathCurriculum(),
                formRegistroRecaudos.getPathTitulo(),
                formRegistroRecaudos.getPathRegistroMercantil()
            };
            guardarUploads(uploads);

            this.usuario.actualizarDatos(
                formRegistroRecaudos.getNombre(), 
                formRegistroRecaudos.getPersona(), formRegistroRecaudos.getRIF(), 
                formRegistroRecaudos.getCI(), formRegistroRecaudos.getEsComunidad(),
                formRegistroRecaudos.getPathISLR(), 
                formRegistroRecaudos.getPathCurriculum(),
                formRegistroRecaudos.getPathTitulo(),
                formRegistroRecaudos.getPathRegistroMercantil()
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