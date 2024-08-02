package main.View.gestionSesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaInicioSesion extends JFrame {
        // Atributos
    private JTextField campoUsuario;
    private JPasswordField campoClave;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;

    public VistaInicioSesion() {

        // configuracion del panel
        setTitle("Courses Manager UCV"); // titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // definir lo que debe suceder cuando se cierra la ventana del JFrame.
        setSize(400, 300); // establecer las dimensiones de la ventana (JFrame)
        setLocationRelativeTo(null); // Centrar la ventana

        JPanel panel = new JPanel(); //  Crea una instancia de JPanel, que es un contenedor ligero para contener otros componentes de la interfaz gráfica de usuario.
        panel.setBackground(Color.BLACK); // Fondo negro
        panel.setLayout(new GridBagLayout()); // Establece el administrador de diseño del panel en GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // se utiliza para especificar las restricciones de diseño de los componentes
        gbc.insets = new Insets(10, 10, 10, 10); // Establece el valor de los rellenos o margen interno

        // Comfiguracion del titulo
        JLabel titulo = new JLabel("Courses Manager UCV"); // nueva instancia
        titulo.setForeground(Color.WHITE); // color del texto
        titulo.setFont(new Font("Arial", Font.BOLD, 16)); // tipo de fuente y dimenciones
        gbc.gridx = 0;//Establece la posición de la celda en la columna 0 del GridBagLayout.
        gbc.gridy = 0;//Establece la posición de la celda en la fila 0 del GridBagLayout.
        gbc.gridwidth = 2; //Especifica que el componente debe ocupar 2 columnas de ancho.
        panel.add(titulo, gbc); // Añade el componente titulo al panel con las restricciones especificadas

        // condiguracion del panel de usuario
        JLabel labelUsuario = new JLabel("Usuario");
        labelUsuario.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(labelUsuario, gbc);

        // configuracion de la informacion de entrada
        campoUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(campoUsuario, gbc);

        // Analogico al panel de usuario
        JLabel labelClave = new JLabel("Clave");
        labelClave.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelClave, gbc);

        campoClave = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(campoClave, gbc);

        // configuracion de los botones

        btnIniciarSesion = new JButton("Iniciar sesión");
        btnIniciarSesion.setActionCommand("INICIAR_SESION");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(btnIniciarSesion, gbc);

        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setActionCommand("IR_A_REGISTRO");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(btnRegistrarse, gbc);

        add(panel);
        setVisible(true);
    }

    // agrega acciones a los botones, que sera dirigido desde el controlador
    public void setControlador(ActionListener controlador) {
        btnIniciarSesion.addActionListener(controlador);
        btnRegistrarse.addActionListener(controlador);
    }
    // Getters y Setters de la informacion
    public String getUsuario() {
        return campoUsuario.getText();
    }

    public String getClave() {
        return new String(campoClave.getPassword());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    // Elimina los datos que se ingresaron en los campos para cuando se vuelava a mostrar
    public void limpiarCampos() {
        campoUsuario.setText("");
        campoClave.setText("");
    }
}
