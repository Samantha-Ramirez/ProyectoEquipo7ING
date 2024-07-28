package main.View.gestionDeSesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Controller.gestionDeSesionUsuario.GestorDeSesion;

public class VistaRegistro extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoClave;
    private JComboBox<String> comboTipoUsuario;
    private JButton btnRegistrarme;
    private JButton btnIrInicioSesion;

    public VistaRegistro() {
        // Configuración del JFrame
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK); // Fondo negro
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Crear y agregar componentes
        JLabel lblTitulo = new JLabel("Registro");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblUsuario, gbc);

        campoUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(campoUsuario, gbc);

        JLabel lblClave = new JLabel("Clave");
        lblClave.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblClave, gbc);

        campoClave = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(campoClave, gbc);

        JLabel lblTipoUsuario = new JLabel("Tipo de Usuario");
        lblTipoUsuario.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblTipoUsuario, gbc);

        comboTipoUsuario = new JComboBox<>(new String[]{"Administrador", "Proponente"});
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(comboTipoUsuario, gbc);

        btnRegistrarme = new JButton("Registrarme");
        btnRegistrarme.setActionCommand("REGISTRARME"); // Establece un comando de acción
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnRegistrarme, gbc);

        // Agregar el botón para ir a inicio de sesión
        btnIrInicioSesion = new JButton("Ir a Inicio de Sesión");
        btnIrInicioSesion.setActionCommand("IR_A_INICIO_SESION"); // Establece un comando de acción
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnIrInicioSesion, gbc);

        add(panel);
        setVisible(true);
    }

    public void setControlador(ActionListener controlador) {
        btnRegistrarme.addActionListener(controlador);
        btnIrInicioSesion.addActionListener(controlador);
    }

    public String getUsuario() {
        return campoUsuario.getText();
    }

    public String getClave() {
        return new String(campoClave.getPassword());
    }

    public String getTipoUsuario() {
        return (String) comboTipoUsuario.getSelectedItem();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        campoUsuario.setText("");
        campoClave.setText("");
        comboTipoUsuario.setSelectedIndex(0);
    }

}







