package main.Controller.gestionBases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaError extends JFrame{
    private JButton btnOk;

    public VistaError(String mensaje) {
        // Configuración del JFrame
        setTitle("ERROR");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK); // Fondo negro
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Crear y agregar componentes

        //Estas instrucciones están configurando la posición y el tamaño del componente lblTitulo
        JLabel lblTitulo = new JLabel("ERROR"); // asign texto al titulo
        lblTitulo.setForeground(Color.WHITE); // denota el color de la fuente
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));// mas especificaciones sobre la fuente
        gbc.gridx = 0; //Establece la posición de la celda en la columna 0 del GridBagLayout. gbc.gridx indica la columna (eje X) donde se colocará el componente.
        gbc.gridy = 0; //Establece la posición de la celda en la fila 0 del GridBagLayout. gbc.gridy indica la fila (eje Y) donde se colocará el componente.
        gbc.gridwidth = 2; //Especifica que el componente debe ocupar 2 columnas de ancho. gbc.gridwidth determina cuántas columnas abarcará el componente en el diseño.
        panel.add(lblTitulo, gbc); // Añade el componente lblTitulo al panel con las restricciones especificadas

        // ANALOGICAMENTE se asignan la misma configuracion anterior con el mensaje, pero con la letra mas chica
        JLabel lblMensaje = new JLabel(mensaje);
        lblMensaje.setForeground(Color.WHITE);
        lblMensaje.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(lblMensaje, gbc);

        // configuracion del boton "OK"
        btnOk = new JButton("OK");
        btnOk.setActionCommand("OK");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnOk, gbc);

        // Añadir el ActionListener al botón OK para cerrar la ventana
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana
            }
        });

        add(panel);
        setVisible(true); // Hacer la ventana visible
    }
}
