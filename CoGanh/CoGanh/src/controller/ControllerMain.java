package controller;

import model.AI;
import model.GameLogic;
import model.Piece;
import view.*;

public class ControllerMain {

	private GameLogic model;
	private AI ai;
	private GameFrame frame;

	private BoardPanel boardPanel;
	private InForPlayerPanel infoPanel;
	private MenuPanel menuPanel;
	private HomePanel homePanel;
	private int x, y;
	private boolean aiMode;

	public ControllerMain() {
		this.x = -1;
		this.y = -1;
		this.aiMode = false;
		model = new GameLogic();
		ai = new AI(model);

		boardPanel = new BoardPanel(this);
		infoPanel = new InForPlayerPanel();
		menuPanel = new MenuPanel();

		homePanel = new HomePanel(new HomePanel.HomeListener() {
			@Override
			public void onPvP() {
				frame.showGame();
			}

			@Override
			public void onAISelected(String level) {
				if (level.equals("Dễ"))
					ai.setDepth(0);
				else if (level.equals("Thường"))
					ai.setDepth(2);
				else if (level.equals("Khó"))
					ai.setDepth(4);
				aiMode = true;
				frame.showGame();
			}
		});

		frame = new GameFrame(homePanel, boardPanel, infoPanel, menuPanel);

		updateBoard();
		updateTurn();
		updateScore();
		backHome();
		setupMenuActions();
	}

	private void setupMenuActions() {
		menuPanel.getNewGame().addActionListener(e -> resetGame());
	}
	private void backHome() {
		menuPanel.getHome().addActionListener(e -> home());
	}

	private void home() {
		frame.showHome();
		resetGame();
		aiMode=false;
	}

	public void click(int rr, int cc) {

		if (x == -1) {
			if (model.isValidToSelect(rr, cc)) {
				x = rr;
				y = cc;
			}
		} else {
			if (x == rr && y == cc) {
				x = -1;
				y = -1;
				return;
			}

			model.move(x, y, rr, cc);
			updateScore();
			updateBoard();
			updateTurn();
			checkWin();
			if (aiMode) {
				javax.swing.SwingUtilities.invokeLater(() -> {
					try {
						Thread.sleep(300);
						aiRun();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				});
			}
			x = -1;
			y = -1;
		}
	}

	public boolean isAiMode() {
		return aiMode;
	}

	public void setAiMode(boolean aiMode) {
		this.aiMode = aiMode;
	}

	private void resetGame() {
		model.reset();
		infoPanel.reset();
		updateBoard();
		updateScore();
		updateTurn();
	}

	private void aiRun() throws InterruptedException {
		ai.aiTurn();
		updateScore();
		updateTurn();
		updateBoard();
		checkWin();
	}

	private void updateBoard() {
		Piece[][] b = model.getBoard().getBoard();
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				boardPanel.updateCell(i, j, b[i][j].getColor());
	}

	private void updateTurn() {
		infoPanel.highlight(model.getTurn());
	}

	private void updateScore() {
		infoPanel.setDiem(model.getP1().getPoint(), model.getP2().getPoint());
	}

	private void checkWin() {
		int c1 = model.checkWinCount();
		int c2 = model.checkWinBi();

		if (c1 == 1 || c2 == 1) {
			frame.thongBaoWin("Người chơi 1");
			resetGame();
		} else if (c1 == -1 || c2 == -1) {
			frame.thongBaoWin("Người chơi 2");
			resetGame();
		}
	}

	public static void main(String[] args) {
		new ControllerMain();
	}
}
