package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePanel extends JPanel {

    private JButton btnPvP;
    private JButton btnAI;
    private JComboBox<String> cbLevel;

    private HomeListener listener;

    public HomePanel(HomeListener listener) {
        this.listener = listener;
        initUI();
    }

    private void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel title = new JLabel("Cờ Gánh 5x5");
        title.setFont(new Font("Arial", Font.BOLD, 28));

        btnPvP = new JButton("2 Người Chơi (PvP)");
        btnAI = new JButton("Chơi với Máy (AI)");

        String[] levels = {"Dễ", "Thường", "Khó"};
        cbLevel = new JComboBox<>(levels);
        cbLevel.setVisible(false);

        // Sự kiện PvP
        btnPvP.addActionListener(e -> {
            if (listener != null) listener.onPvP();
        });

        // Sự kiện AI
        btnAI.addActionListener(e -> {
            cbLevel.setVisible(true);
        });

        // Chọn độ khó
        cbLevel.addActionListener(e -> {
            if (cbLevel.isVisible()) {
                String lv = cbLevel.getSelectedItem().toString();
                if (listener != null) listener.onAISelected(lv);
            }
        });

        gbc.insets = new Insets(15, 15, 15, 15);

        gbc.gridx = 0; gbc.gridy = 0;
        add(title, gbc);

        gbc.gridy = 1;
        add(btnPvP, gbc);

        gbc.gridy = 2;
        add(btnAI, gbc);

        gbc.gridy = 3;
        add(cbLevel, gbc);
    }

    // ===== CALLBACK GỬI VỀ CONTROLLER =====
    public interface HomeListener {
        void onPvP();
        void onAISelected(String level);
    }
}