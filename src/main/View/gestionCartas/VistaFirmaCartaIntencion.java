package main.View.gestionCartas;

import javax.swing.*;

import main.Controller.gestionCartas.GestorCartaIntencion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaFirmaCartaIntencion extends JFrame {
    private GestorCartaIntencion gestor;

    public VistaFirmaCartaIntencion() {
        gestor = new GestorCartaIntencion();
        setTitle("Administrador | Firmar Carta de Intención");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Información:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField infoText = new JTextField(20);
        infoText.setBounds(150, 20, 165, 25);
        panel.add(infoText);

        JLabel firmaLabel = new JLabel("Firma:");
        firmaLabel.setBounds(10, 50, 80, 25);
        panel.add(firmaLabel);

        JTextField firmaText = new JTextField(20);
        firmaText.setBounds(150, 50, 165, 25);
        panel.add(firmaText);

        JLabel naturalezaLabel = new JLabel("Naturaleza del Curso:");
        naturalezaLabel.setBounds(10, 80, 140, 25);
        panel.add(naturalezaLabel);

        JTextField naturalezaText = new JTextField(20);
        naturalezaText.setBounds(150, 80, 165, 25);
        panel.add(naturalezaText);

        JLabel validezLabel = new JLabel("Validez:");
        validezLabel.setBounds(10, 110, 80, 25);
        panel.add(validezLabel);

        JTextField validezText = new JTextField(20);
        validezText.setBounds(150, 110, 165, 25);
        panel.add(validezText);

        JButton signButton = new JButton("Firmar");
        signButton.setBounds(10, 140, 150, 25);
        panel.add(signButton);

        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestor.firmarCarta(
                        infoText.getText(),
                        firmaText.getText(),
                        naturalezaText.getText(),
                        validezText.getText()
                );
                JOptionPane.showMessageDialog(null, "Carta firmada con éxito!");
            }
        });
    }

    public static void main(String[] args) {
        new VistaFirmaCartaIntencion();
    }
}

