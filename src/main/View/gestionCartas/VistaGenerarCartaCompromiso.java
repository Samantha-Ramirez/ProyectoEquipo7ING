package main.View.gestionCartas;

import javax.swing.*;

import main.Controller.gestionCartas.GestorCartaCompromiso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGenerarCartaCompromiso extends JFrame {
    private GestorCartaCompromiso gestor;

    public VistaGenerarCartaCompromiso() {
        gestor = new GestorCartaCompromiso();
        setTitle("Administrador | Generar Carta de Compromiso");
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

        JLabel acuerdoLabel = new JLabel("Acuerdo de Retribución:");
        acuerdoLabel.setBounds(10, 20, 150, 25);
        panel.add(acuerdoLabel);

        JTextField acuerdoText = new JTextField(20);
        acuerdoText.setBounds(160, 20, 165, 25);
        panel.add(acuerdoText);

        JLabel formularioLabel = new JLabel("Formulario de Generación:");
        formularioLabel.setBounds(10, 50, 150, 25);
        panel.add(formularioLabel);

        JTextField formularioText = new JTextField(20);
        formularioText.setBounds(160, 50, 165, 25);
        panel.add(formularioText);

        JButton generateButton = new JButton("Generar");
        generateButton.setBounds(10, 80, 150, 25);
        panel.add(generateButton);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestor.generarCarta(
                        acuerdoText.getText(),
                        formularioText.getText()
                );
                JOptionPane.showMessageDialog(null, "Carta generada con éxito!");
                
            }
        });
    }

    public static void main(String[] args) {
        new VistaGenerarCartaCompromiso();
    }
}