package main.Controller.gestionBases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorBase implements ActionListener {
    public GestorBase(){
        
    }
    public String getPathNombre(String filePath){
        String nombre = "";
        if (!filePath.isEmpty()) {  
            File file = new File(filePath);  
            nombre = file.getName(); 
        }
        return nombre;
}
    public void guardarUploads(String[] uploads){
        String basePath = "src/main/Data/";
        for(int i = 0; i<uploads.length; i++){
            String filePath = uploads[i];  
            if (!filePath.isEmpty()) {  
                File file = new File(filePath);  
                String destinationPath = basePath + file.getName();  
                try {  
                    // Crear el directorio de uploads si no existe  
                    Files.createDirectories(Paths.get(basePath));  
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
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
