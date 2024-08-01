package main.Controller.gestionCartas;

import main.Model.gestionCartas.*;

public class GestorCartaIntencion {
    private CartaIntencion cartaIntencion;

    public GestorCartaIntencion() {
        this.cartaIntencion = new CartaIntencion();
    }

    public void firmarCarta(String informacion, String firma, String naturalezaDelCurso, String validez) {
        cartaIntencion.setInformacion(informacion);
        cartaIntencion.setFirma(firma);
        cartaIntencion.setNaturalezaDelCurso(naturalezaDelCurso);
        cartaIntencion.setValidez(validez);
        // Lógica adicional para firmar la carta
    }

    public CartaIntencion getCartaIntencion() {
        return cartaIntencion;
    }
}