package main.Model.gestionSesionUsuario;

// Importaciones necesarias para el manejo de archivos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Abstracta {
    public Abstracta(){

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
                if(sep == ",")
                    writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace(); // manejo de excepciones con respecto a las entradas
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
