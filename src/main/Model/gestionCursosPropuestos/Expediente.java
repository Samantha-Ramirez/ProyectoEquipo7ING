package main.Model.gestionCursosPropuestos;

import main.Model.gestionCartas.*;
import main.Model.gestionSesionUsuario.Usuario;
// importar base
import main.Model.gestionBases.Base;

import java.util.Vector;

public class Expediente extends Base  {
    private Usuario usuario;
    private Vector<CartaCompromiso> cartasCompromisos;
    private Vector<CartaIntencion> cartasIntencion;
    public Expediente(Usuario usuario){
        this.usuario = usuario;
        this.cartasCompromisos = new Vector<>();
        this.cartasIntencion = new Vector<>();
    }
    public Vector<String> getCartasCompromiso(){
        return new Vector<>();
    }
    public Vector<String> getCartasIntencion(){
        return new Vector<>();
    }
}
