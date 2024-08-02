package main.Model.gestionBases;

// Importaciones necesarias para el manejo de archivos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;  
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Base {
    public Base(){

    }
    // Método para registrar los datos del usuario en archivos
    public void guardarDatos(String fileName, String[] datos, String sep, Boolean type){
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)
        fileName = basePath + fileName;
        if ((!type && !Files.exists(Paths.get(fileName)) || type && Files.exists(Paths.get(fileName)))) {// verifica si el archivo de usuario existe, en caso de que exista retorna falso, pues ese usuario ya esta registrado
            try (FileWriter writer = new FileWriter(fileName, type)) { // abre el arcihivo en modo lectura // 'true' habilita el modo de append
                for(int i = 0; i<datos.length; i++){
                    writer.write(datos[i] + sep);
                }
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace(); // manejo de excepciones con respecto a las entradas
            }
        }
    }
    
    public void actualizarDatos(String fileName, String[] datos, String sep){
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)
        fileName = basePath + fileName;  
        // Define the new content you want to place in the file  
        String newContent = String.join(sep, datos);
        // for(int i = 0; i<datos.length; i++){
        //     newContent += newContent + datos[i] + sep;
        // }
        try {  
            // Set the path to the file  
            Path path = Paths.get(fileName);  

            // Write the new content to the file, replacing existing text  
            Files.write(path, newContent.getBytes());  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    }

    public void actualizarDatos(String fileName, String[] datos, String sep, String match){
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)
        fileName = basePath + fileName;  
        // Define the new content you want to place in the file  
        if (Files.exists(Paths.get(fileName))) {
            try {
                // Leer el contenido del archivo
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    // Modificar la línea correspondiente
                    if (linea.contains(match)) {
                        // String[] subPartes = linea.split(",");
                        // String[] subPartes = partes[1].split(", ", 2);
                        // subPartes[n] = "Estado = " + estado;
                        // subPartes[1] = "Información = " + informacion;
                        // linea = partes[0] + ": " + String.join(", ", subPartes);
                        linea = String.join(sep, datos);
                        // if(sep == ",")
                        // writer.write("\n");
                    }
                    contenido.append(linea).append(System.lineSeparator());
                    
                }
                reader.close();

                // Escribir el contenido modificado de nuevo al archivo
                FileWriter writer = new FileWriter(fileName);
                writer.write(contenido.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> leerDatos(String fileName, int n){
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)
        fileName = basePath + fileName;
        List<String> datos = new ArrayList<String>();
        if (!Files.exists(Paths.get(fileName))) {
            return datos; // Retorna false si el archivo no existe
        }
        // abre el archivo en modo lectura
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for(int i = 0; i<n; i++){
                datos.add(reader.readLine());
            }
            return datos;

        } catch (IOException e) {// manejo de excepcion
            e.printStackTrace();
            return datos;
        }
    }
    
    public List<String> leerDatos(String fileName){
        String basePath = "src/main/Data/";// direccion donde se guardara el txt(data)
        fileName = basePath + fileName;
        List<String> datos = new ArrayList<String>();
        if (!Files.exists(Paths.get(fileName))) {
            return datos; // Retorna false si el archivo no existe
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {  
            String line;  
            while ((line = reader.readLine()) != null) {
                datos.add(line);
            }
            return datos;
        } catch (IOException e) {  
            e.printStackTrace();
            return datos; 
        }  
    }
}
