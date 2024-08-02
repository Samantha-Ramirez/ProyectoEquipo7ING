package main.Model.gestionSesionUsuario;

public class Proponente extends Usuario {
    protected String esAliado;
    protected String persona; //Normal, Juridica
    protected String RIF;
    protected String CI;
    protected String esComunidad;
    protected String pathISLR;
    protected String pathCurriculum;
    protected String pathTitulo;
    protected String pathRegistroMercantil;

    public Proponente (String nombreUsuario, String clave){
        super(nombreUsuario, clave);
    }

    public void actualizarDatos(
        String nombreUsuario, String persona, String RIF, 
        String CI, String esComunidad,
        String pathISLR, String pathCurriculum,
        String pathTitulo, String pathRegistroMercantil){
        this.persona = persona;
        this.RIF = RIF;
        this.CI = CI;
        this.esComunidad = esComunidad;
        this.pathISLR = pathISLR;
        this.pathCurriculum = pathCurriculum;
        this.pathTitulo = pathTitulo;
        this.pathRegistroMercantil = pathRegistroMercantil;
        
        String nombreArch = this.getNombreUsuario() + ".txt";
        String[] datos = {
            this.persona,
            this.RIF, 
            this.CI, 
            this.esComunidad,
            this.pathISLR,
            this.pathCurriculum,
            this.pathTitulo,
            this.pathRegistroMercantil,
        };
        guardarDatos(nombreArch, datos, "\n", true);
    }
}
