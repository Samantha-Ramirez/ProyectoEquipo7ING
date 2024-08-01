package main.View.gestionBases;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class VistaBase extends Ventana {  
    protected JPanel panelCentral;

    public VistaBase(String title) {  
        // Configuración de la ventana principal
        super(title);
        setSize(800, 800);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    
    public JPanel crearPanel(Boolean tabla, int rows, int cols){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Añadido espacio entre componentes

        if (tabla){
            panel.setLayout(new GridLayout(rows, cols, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega borde vacío para centrado
        }

        return panel;
    }
    
    public void agregarPanelCentral(JPanel panel, String pos){
        add(panel, pos);
        this.panelCentral = panel;
    }

    public JButton agregarBoton(JPanel panel, String title){
        // Configurar boton 
        JButton boton = new JButton(title);
        boton.setPreferredSize(new Dimension(100, 40));  
        boton.setFocusPainted(false);  
        boton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));  
        boton.setBackground(Color.WHITE);
        boton.setForeground(Color.BLACK);
        boton.setFont(new Font("Arial", Font.PLAIN, 10));  

        // Agregar boton al panel  
        panel.add(boton);
        return boton;
    }
    
    public void agregarLabel(JPanel panel, String title, Boolean fuente){
        JLabel label = new JLabel(title);
        if (fuente)
            label.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Agregar label al panel
        panel.add(label); 
    }
    
    public JText agregarRecuadroTexto(JPanel panel, String title, String placeholder){
        // Crear label
        agregarLabel(panel, title, false);

        // Configurar recuadro de texto  
        JText textField = new JText(16);  
        textField.setPlaceholder(placeholder); 
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
        
        // Agregar recuadro de texto al panel
        panel.add(textField);
        return textField;
    }

    public JText agregarBotonAdjunto(JPanel panel, String title, String placeholder){
        // Crear label
        agregarLabel(panel, title, false);
        // Crear boton 
        JButton botonElegirArch = agregarBoton(panel, placeholder);
        JText pathArch = new JText(0);

        botonElegirArch.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                JFileChooser fileChooser = new JFileChooser();  
                int returnValue = fileChooser.showOpenDialog(null);  
                if (returnValue == JFileChooser.APPROVE_OPTION) {  
                    File selectedFile = fileChooser.getSelectedFile();  
                    pathArch.setText(selectedFile.getAbsolutePath());  
                }  
            }  
        });
        return pathArch;
    }

    public Boolean esDatosCompletos(JText[] recuadrosTexto){
        for(int i = 0; i<recuadrosTexto.length; i++){
            if (recuadrosTexto[i].getText().equals(recuadrosTexto[i].placeholder) || recuadrosTexto[i].getText().trim().isEmpty()) 
                return false;
        }
        return true;
    }

    public void botonAbrirVentana(JButton boton, Ventana ventana){
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(true);
            }
        });
    } 

    public JComboBox<String> agregarCombo(JPanel panel, String title, String op1, String op2){
        // Crear label
        agregarLabel(panel, title, false);

        JComboBox<String> combo = new JComboBox<>(new String[]{op1, op2});
        // gbc.gridx = 1;
        // gbc.gridy = 3;
        panel.add(combo);
        return combo;
    }
}  