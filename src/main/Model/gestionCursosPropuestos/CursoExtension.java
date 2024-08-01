package main.Model.gestionCursosPropuestos;

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

// package main.Model.gestionPropuesta;

// import java.util.List;

// import main.Model.gestionBases.Base;

// public class CursoExtension extends Base {
//     // private Usuario usuario; se decide ligar al proponente con la propuesta 
//     // y no con el curso como se habia pensado inicialmente en el diagrama de clases del modelo de dominio
//     private Propuesta propuesta;
//     private String areaConocimiento;
//     private String modalidad;
//     private String tipoCurso;
//     private float ingresosNetos;
//     //FIX:atributos

//     public CursoExtension (Propuesta propuesta){
//         this.propuesta = propuesta;
//         this.areaConocimiento = "Ciencias";
//         this.modalidad = "online";
//         this.tipoCurso = "curso";
//         this.ingresosNetos = 0;
//         guardarCurso();
//     }

//     public void guardarCurso(){
//         String[] datos = {
//             // this.usuario.getNombreUsuario(), 
//             this.propuesta.getNombre(), 
//             this.areaConocimiento,
//             this.modalidad,
//             this.tipoCurso,
//             String.valueOf(this.ingresosNetos)};
//         guardarDatos("CursoExtension.txt", datos, ",", true);
//     }

// }
