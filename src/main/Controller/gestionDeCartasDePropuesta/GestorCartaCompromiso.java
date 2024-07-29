package main.Controller.gestionDeCartasDePropuesta;

import main.Model.gestionDeCartasDePropuesta.*;

public class GestorCartaCompromiso {
    private CartaCompromiso cartaCompromiso;

    public GestorCartaCompromiso() {
        this.cartaCompromiso = new CartaCompromiso();
    }

    public void generarCarta(String acuerdoRetribucion, String formularioGeneracion) {
        cartaCompromiso.setAcuerdoRetribucion(acuerdoRetribucion);
        cartaCompromiso.setFormularioGeneracion(formularioGeneracion);
        // Lógica adicional para generar la carta
    }

    public CartaCompromiso getCartaCompromiso() {
        return cartaCompromiso;
    }
}