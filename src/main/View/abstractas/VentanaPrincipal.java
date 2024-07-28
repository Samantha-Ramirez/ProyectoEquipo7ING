package main.View.abstractas;
import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {  

    public VentanaPrincipal(String title) {  
        // Configuración de la ventana principal
        super(title);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(Color.BLACK);
        JLabel titulo = new JLabel(title, SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        panelSuperior.add(titulo, BorderLayout.CENTER);

        // Agregar panel
        add(panelSuperior, BorderLayout.NORTH);
    }
    public JPanel crearPanel(Boolean setColRow){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 80)); // Añadido espacio entre componentes
        if (setColRow){
            panel.setLayout(new GridLayout(3, 2, 10, 10)); // 4 filas, 1 columna con espacio entre filas
        }
        return panel;
    }
    public void agregarPanel(JPanel panel, String pos){
        add(panel, pos);
    }

    public void agregarBoton(JPanel panel, String title){
        // Configurar boton 
        JButton boton = new JButton(title);
        boton.setPreferredSize(new Dimension(100, 40));  
        boton.setFocusPainted(false);  
        boton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));  
        boton.setBackground(Color.WHITE);  
        boton.setForeground(Color.BLACK);  
        boton.setFont(new Font("Arial", Font.PLAIN, 16));  

        // Agregar boton al panel  
        panel.add(boton); 
    }        
    
    public void agregarRecuadroTexto(JPanel panel, String title, String placeholder){
        // Crear label
        JLabel label = new JLabel(title);  
        // Configurar recuadro de texto  
        JTextField textField = new JTextField(20);  
        textField.setText(placeholder);  
        textField.setForeground(Color.GRAY); // Color placeholder

        // Agregar una accion para limpiar el placeholder
        textField.addFocusListener(new java.awt.event.FocusAdapter() {  
            public void focusGained(java.awt.event.FocusEvent evt) {  
                if (textField.getText().equals(placeholder)) {  
                    textField.setText("");  
                    textField.setForeground(Color.BLACK);  
                }  
            }  
            public void focusLost(java.awt.event.FocusEvent evt) {  
                if (textField.getText().isEmpty()) {  
                    textField.setForeground(Color.GRAY);  
                    textField.setText(placeholder);  
                }  
            }  
        });  

        // Agregar label al panel
        panel.add(label); 
        // Agregar recuadro de texto al panel
        panel.add(textField);
    }


}  