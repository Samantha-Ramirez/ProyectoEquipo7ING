
package main.View.gestionCursosPropuestos;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class VistaCursosPropuestos extends JFrame {
    public VistaCursosPropuestos(Vector<String> cursosPropuestos) {
        setTitle("Proponente | Ver cursos propuestos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        // Crear el panel del título con fondo negro
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.BLACK); // color del fonde del panel
        JLabel labelTitulo = new JLabel("Proponente | Ver cursos Propuestos");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));// configuracion de fuente
        labelTitulo.setForeground(Color.WHITE);// color de fuente
        panelTitulo.add(labelTitulo);

        // Crear el panel de la tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new GridBagLayout()); // Usar GridBagLayout para centrar

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre celdas

        // Crear y añadir encabezados de la tabla con mayor tamaño de fuente
        JLabel labelCurso = new JLabel("Curso");
        JLabel labelEstado = new JLabel("Estado del aval");
        labelCurso.setFont(new Font("Arial", Font.BOLD, 14));
        labelEstado.setFont(new Font("Arial", Font.BOLD, 14));

        // configuracion de la tabla
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        // agrega la coluna de "curso"  la tabla
        gbc.anchor = GridBagConstraints.CENTER;
        panelTabla.add(labelCurso, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panelTabla.add(labelEstado, gbc);

        // Añadir los datos de los cursos propuestos con mayor tamaño de fuente
        int row = 1;
        for (String cursoEstado : cursosPropuestos) {
            String[] partes = cursoEstado.split(",");
            //configuracion del nombre del curso y del estado cuando lo lee del vector
            //if (partes.length == 2) {
                JLabel labelCursoNombre = new JLabel(partes[2]);
                JLabel labelEstadoAval = new JLabel(partes[1]);
                labelCursoNombre.setFont(new Font("Arial", Font.PLAIN, 16));
                labelEstadoAval.setFont(new Font("Arial", Font.PLAIN, 16));

                gbc.gridx = 0;
                gbc.gridy = row;
                gbc.weightx = 1.0;
                gbc.anchor = GridBagConstraints.CENTER;
                panelTabla.add(labelCursoNombre, gbc);

                gbc.gridx = 1;
                gbc.gridy = row;
                panelTabla.add(labelEstadoAval, gbc);

                row++;
            //}
        }

        // Añadir los paneles al panel principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);

        // Añadir el panel principal al frame
        add(panelPrincipal);
    }
    
    // Mensaje de que se activo un boton
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
