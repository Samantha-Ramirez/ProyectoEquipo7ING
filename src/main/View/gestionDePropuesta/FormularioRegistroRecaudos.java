package main.View.gestionDePropuesta;
import java.awt.*;
import javax.swing.*;
import main.View.abstractas.*;

public class FormularioRegistroRecaudos extends VentanaPrincipal {  

    public FormularioRegistroRecaudos(String title) {  
        super(title);

        JPanel panelCentral = crearPanel(false);
        agregarRecuadroTexto(panelCentral, title, title);
        agregarBoton(panelCentral, title);

        agregarPanel(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {  
        FormularioRegistroRecaudos form = new FormularioRegistroRecaudos("Proponente | Registrar recaudos");  
        form.setVisible(true);  
    }  
}  