package main.Model.gestionPropuesta;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.Model.gestionSesionUsuario.*;

public class CursoExtension {
    private Usuario usuario;
    private Propuesta propuesta;
    private String areaConocimiento;
    private String modalidad;
    private String tipoCurso;
    private float ingresosNetos;

    public CursoExtension (Usuario usuario, Propuesta propuesta){
        this.propuesta = propuesta;
        this.usuario = usuario;
        this.areaConocimiento = "";
        this.modalidad = "online";
        this.tipoCurso = "curso";
        this.ingresosNetos = 0;
        guardarCurso();
    }

    public void guardarCurso(){
        String nombreArch = "src/main/Data/CursoExtension.txt";
        String[] datos = {
            this.usuario.nombreUsuario, 
            this.propuesta.nombre, 
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
