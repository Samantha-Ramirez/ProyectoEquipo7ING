package main.Model.gestionDePropuesta;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CursoExtension {
    private Propuesta propuesta;
    private String areaConocimiento;
    private String modalidad;
    private String tipoCurso;
    private float ingresosNetos;

    public CursoExtension (Propuesta propuesta){
        this.propuesta = propuesta;
    }

    public void guardarPropuesta(){
        String nombreArch = "src/main/Data/Propuesta.txt";
        String[] datos = {
            this.areaConocimiento, 
            this.modalidad,
            this.tipoCurso, 
            String.valueOf(this.ingresosNetos)};
        // verifica que exista el archivo antes de abrir el el archivo
        if (Files.exists(Paths.get(nombreArch))) {

            // abre el archivo en modo escritura
            try (FileWriter usuarioWriter = new FileWriter(nombreArch, true)) { // 'true' habilita el modo de append
                for(int i = 0; i<datos.length; i++){
                    usuarioWriter.write(datos[i] + ",");
                }
                usuarioWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
