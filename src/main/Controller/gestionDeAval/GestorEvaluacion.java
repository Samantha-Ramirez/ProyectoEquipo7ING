import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EvaluacionesDashboard extends JFrame {

    public EvaluacionesDashboard() {
        // Configuración de la ventana principal
        setTitle("Evaluaciones | Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.BLACK);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centra el contenido
        JLabel titulo = new JLabel("Evaluaciones | Dashboard");
        titulo.setForeground(Color.WHITE);
        panelSuperior.add(titulo);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con los componentes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(4, 1, 10, 10)); // 4 filas, 1 columna con espacio entre filas
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega borde vacío para centrado

        for (int i = 1; i <= 4; i++) {
            JPanel lineaPanel = new JPanel();
            lineaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centra los componentes dentro de la línea

            JLabel cursoLabel = new JLabel("Curso #" + i + " - ");
            JButton btnResponderEvaluacion = new JButton("Responder evaluación de aval");
            JButton btnGenerarCarta = new JButton("Generar carta de compromiso");
            JButton btnFirmaCarta = new JButton("Firma carta de intencion");
            
            // Acción para el botón "Responder evaluación de aval"
            btnResponderEvaluacion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre la ventana de Evaluación de Aval
                    EvaluacionAval evaluacionAvalFrame = new EvaluacionAval();
                    evaluacionAvalFrame.setVisible(true);
                }
            });
            
            lineaPanel.add(cursoLabel);
            lineaPanel.add(btnResponderEvaluacion);
            lineaPanel.add(btnGenerarCarta);
            lineaPanel.add(btnFirmaCarta);
            
            panelCentral.add(lineaPanel);
        }

        add(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EvaluacionesDashboard dashboard = new EvaluacionesDashboard();
            dashboard.setVisible(true);
        });
    }
}
