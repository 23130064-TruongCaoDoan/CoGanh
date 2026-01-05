package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private CardLayout card;
    private JPanel mainPanel;

    // Panels
    private HomePanel home;
    private JPanel gamePanel;

    public GameFrame(HomePanel homePanel, BoardPanel board, InForPlayerPanel info, MenuPanel menu) {
        super("Cờ Gánh 5x5");

        this.home = homePanel;

        card = new CardLayout();
        mainPanel = new JPanel(card);

        // ============ GAME PANEL ==============
        gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

        gamePanel.add(info);
        gamePanel.add(board);
        gamePanel.add(menu);

        // Add vào card layout
        mainPanel.add(home, "HOME");
        mainPanel.add(gamePanel, "GAME");

        add(mainPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showHome() {
        card.show(mainPanel, "HOME");
    }

    public void showGame() {
        card.show(mainPanel, "GAME");
    }

    public void thongBaoWin(String p) {
        JOptionPane.showMessageDialog(this, p + " thắng!", "Kết thúc", JOptionPane.INFORMATION_MESSAGE);
    }
}