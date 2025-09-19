package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            DrawingPanel panel = new DrawingPanel();
            frame.add(panel, BorderLayout.CENTER);

            // ComboBox de seleção de forma
            JComboBox<String> shapeSelector = new JComboBox<>(new String[]{"Círculo", "Retângulo"});
            shapeSelector.addActionListener(e -> {
                String selected = (String) shapeSelector.getSelectedItem();
                if ("Retângulo".equals(selected)) {
                    panel.setCurrentShape(FormaTipo.RECTANGLE);
                } else {
                    panel.setCurrentShape(FormaTipo.CIRCLE);
                }
            });

            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            topPanel.add(new JLabel("Forma:"));
            topPanel.add(shapeSelector);

            frame.add(topPanel, BorderLayout.NORTH);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
