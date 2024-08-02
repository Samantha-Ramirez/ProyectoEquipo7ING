package main.Model.gestionCursosPropuestos;

import main.Model.gestionSesionUsuario.Usuario;
// importar base
import main.Model.gestionBases.Base;

import java.util.List;
import java.util.Vector;

public class Expediente extends Base  {
    private Usuario usuario;
    public Expediente(Usuario usuario){
        this.usuario = usuario;
    }

    public Vector<String> getCartas(){
        List<String> datos = leerDatos(usuario.getNombreUsuario()+"_expediente.txt");
        Vector<String> cartas = new Vector<>();
        if(datos.size() != 0){
            for(int i = 0; i<datos.size(); i++){
                // Propuesta propuesta = new Propuesta(dato[0], dato[1], 
                // dato[2], dato[3], dato[4], dato[5], dato[6], dato[7],
                // dato[8], dato[9], dato[10])
                // getPropuesta(Nombre);
                cartas.add(datos.get(i));
            }
        }
        return cartas;
    }
}
