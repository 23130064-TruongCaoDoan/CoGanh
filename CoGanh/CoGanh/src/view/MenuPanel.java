package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	private JButton newGame, home;

	public MenuPanel() {
		setLayout(new FlowLayout());
		add(newGame = new JButton("Ván Mới"));
		add(home = new JButton("Home"));
	}

	public JButton getNewGame() {
		return newGame;
	}

	public void setNewGame(JButton newGame) {
		this.newGame = newGame;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

}