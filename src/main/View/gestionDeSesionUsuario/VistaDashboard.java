package main.View.gestionDeSesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class VistaDashboard extends JFrame{
    private JPanel panelPrincipal;

    // Configuracion principal de la ventana
    public VistaDashboard() {
        // Configuración del JFrame
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear el panel principal
        panelPrincipal = new JPanel(new CardLayout());
        add(panelPrincipal);
    }
    /// donde estaran las configuraciones de paneles comunes en los 3 tipos de Dashboard
    private JPanel crearPanelComun(String titulo, ActionListener controlador) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);// color del fondo

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(Color.BLACK);// linea negra en la parte superior
        panelSuperior.setPreferredSize(new Dimension(panel.getWidth(), 40));// dimensiones

        // configuracion del titulo
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(lblTitulo, BorderLayout.WEST);

        // Configuracion del boton dee cerrar sesion
        JButton btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setActionCommand("CERRAR_SESION"); // agrega el comando que sera usado en el controlador
        btnCerrarSesion.setPreferredSize(new Dimension(120, 25)); // configuracion del boton, dimensiones
        panelSuperior.add(btnCerrarSesion, BorderLayout.EAST); // agrega el boton a la parte superior
        btnCerrarSesion.addActionListener(controlador); // asigna la accion al boton, que sera usada en el controlador

        panel.add(panelSuperior, BorderLayout.NORTH);
        // configuraciond del resto de la ventana
        JPanel panelContenido = new JPanel();
        panelContenido.setBackground(Color.WHITE);
        panelContenido.setLayout(new GridBagLayout());
        panel.add(panelContenido, BorderLayout.CENTER);

        return panel;
    }

    public void mostrarDashboardAliado(ActionListener controlador) {
        //crea el panel de Alido haciendo uso de la configuracion bas e de dashboard
        JPanel panelAliado = crearPanelComun("Aliado | Dashboard", controlador);
        JPanel panelContenido = (JPanel) panelAliado.getComponent(1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Configuracion de los botones

        // Agrega texto al boton de cargar formilacion e instancia el componente
        JButton btnCargarFormulacion = new JButton("Cargar formulación de curso");
        gbc.gridx = 0;//Establece la posición de la celda en la columna 0 del GridBagLayout. gbc.gridx indica la columna (eje X) donde se colocará el componente.
        gbc.gridy = 0;//Establece la posición de la celda en la fila 0 del GridBagLayout. gbc.gridy indica la fila (eje Y) donde se colocará el componente.
        gbc.gridwidth = 1;  //Especifica que el componente debe ocupar 1 columna de ancho. gbc.gridwidth determina cuántas columnas abarcará el componente en el diseño.
        panelContenido.add(btnCargarFormulacion, gbc);  // Añade el componente btnCargarFormulacion al panel con las restricciones especificadas

        // respectivamente la configuracion de los otros botones
        JButton btnVerCursos = new JButton("Ver cursos propuestos");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelContenido.add(btnVerCursos, gbc);

        JButton btnVerExpediente = new JButton("Ver expediente");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelContenido.add(btnVerExpediente, gbc);

        // agrega funcionalidad a los botones, que sera usado en el controlador
        btnCargarFormulacion.setActionCommand("CARGAR_FORMULACION");
        btnCargarFormulacion.addActionListener(controlador);

        btnVerCursos.setActionCommand("VER_CURSOS");
        btnVerCursos.addActionListener(controlador);

        btnVerExpediente.setActionCommand("VER_EXPEDIENTE");
        btnVerExpediente.addActionListener(controlador);

        // agregar el componente aliado al panel principal
        panelPrincipal.add(panelAliado, "Aliado");
        CardLayout cl = (CardLayout) (panelPrincipal.getLayout());
        cl.show(panelPrincipal, "Aliado");

        setVisible(true);

    }

    // la configuracion de las otras opcions de pantallas es similar
    public void mostrarDashboardProponente(ActionListener controlador) {
        JPanel panelProponente = crearPanelComun("Proponente | Dashboard", controlador);
        JPanel panelContenido = (JPanel) panelProponente.getComponent(1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton btnRegistrarRecaudos = new JButton("Registrar recaudos");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panelContenido.add(btnRegistrarRecaudos, gbc);

        JButton btnVerCursos = new JButton("Ver cursos propuestos");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelContenido.add(btnVerCursos, gbc);

        JButton btnVerExpediente = new JButton("Ver expediente");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelContenido.add(btnVerExpediente, gbc);

        btnRegistrarRecaudos.setActionCommand("REGISTRAR_RECUADOS");
        btnRegistrarRecaudos.addActionListener(controlador);

        btnVerCursos.setActionCommand("VER_CURSOS");
        btnVerCursos.addActionListener(controlador);

        btnVerExpediente.setActionCommand("VER_EXPEDIENTE");
        btnVerExpediente.addActionListener(controlador);

        panelPrincipal.add(panelProponente, "Proponente");
        CardLayout cl = (CardLayout) (panelPrincipal.getLayout());
        cl.show(panelPrincipal, "Proponente");

        setVisible(true);
    }

    public void mostrarDashboardAdministrador(ActionListener controlador) {
        JPanel panelAdministrador = crearPanelComun("Administrador | Dashboard", controlador);
        JPanel panelContenido = (JPanel) panelAdministrador.getComponent(1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton btnVerPropuestas = new JButton("Ver propuestas");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelContenido.add(btnVerPropuestas, gbc);

        btnVerPropuestas.setActionCommand("VER_PROPUESTAS");
        btnVerPropuestas.addActionListener(controlador);

        panelPrincipal.add(panelAdministrador, "Administrador");
        CardLayout cl = (CardLayout) (panelPrincipal.getLayout());
        cl.show(panelPrincipal, "Administrador");

        setVisible(true);
    }
    // Mensaje de que se activo un boton
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
