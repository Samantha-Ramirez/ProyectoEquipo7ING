package main.Model.gestionDeCursosPropuestos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class CursoExtension {
    private String nombreUsuario;
    private Vector<String> cursosPropuestos;

    public CursoExtension(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.cursosPropuestos = new Vector<>();
    }
    // Lee el archivo para obtener las propuestas correspondientes al usuario
    public void leerArchivoPropuestas() {
        String archivo = "src/main/Data/propuesta.txt";// direccion donde está el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {// va a leer mientras no llegue al final del archivo
                String[] partes = linea.split(",");// divisale la linea en "partes", que las separa ','
                if (partes.length >= 3) {// toma las primeras tres partes
                    String usuario = partes[0];
                    String estado = partes[1];
                    String nombre = partes[2];
                    if (usuario.equals(this.nombreUsuario)) {
                        cursosPropuestos.add(estado + "," + nombre);// guarda en el vector el nombre de la propuesta y el estado
                    }
                }
            }
        } catch (IOException e) {
            // manejo de excepciones
            e.printStackTrace();
        }
    }
    // Getters
    public String getNombreUsuario() { return nombreUsuario;}
    public Vector<String> getCursosPropuestos() {return cursosPropuestos;}

}
