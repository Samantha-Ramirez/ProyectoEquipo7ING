package main.Model.gestionCartas;

public class CartaIntencion {
    private String informacion;
    private String firma;
    private String naturalezaDelCurso;
    private String validez;

    // Getters y Setters
    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getNaturalezaDelCurso() {
        return naturalezaDelCurso;
    }

    public void setNaturalezaDelCurso(String naturalezaDelCurso) {
        this.naturalezaDelCurso = naturalezaDelCurso;
    }

    public String getValidez() {
        return validez;
    }

    public void setValidez(String validez) {
        this.validez = validez;
    }
}