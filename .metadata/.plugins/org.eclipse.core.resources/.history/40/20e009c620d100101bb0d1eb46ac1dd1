package model;

public class GameLogic {
	private Board board;
	private Player p1, p2;
	private Boolean turn;
	private Move move;

	public GameLogic() {
		super();
		this.board = new Board();
		this.move = new Move(board);
		this.p1 = new Player();
		this.p2 = new Player();
		this.turn = true;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public Boolean getTurn() {
		return turn;
	}

	public void setTurn(Boolean turn) {
		this.turn = turn;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public void move(int fX, int fY, int toX, int toY) {
		String currentColor = turn ? "white" : "black";
		if (move.diChuyen(fX, fY, toX, toY, currentColor)) {
			int point = move.anQuan(fX, fY, toX, toY, currentColor);
			if (turn) {
				p1.setPoint(p1.getPoint() + point);
			} else {
				p2.setPoint(p2.getPoint() + point);
			}
			turn = !turn;

		}
	}

	public boolean isValidToSelect(int r, int c) {
		String currentColor = turn ? "white" : "black";
		String pieceColor = board.getPiece(r, c).getColor();
		return pieceColor.equals(currentColor);
	}

	public void reset() {
		board.reset();
		p1.setPoint(0);
		p2.setPoint(0);
		turn = true;

	}
	public int checkWinCount() {
		if(board.countPiece(true)==0) {
			return -1;
		}
		else if(board.countPiece(false)==0) {
			return 1;
		}
		return 0;
	}
	public int checkWinBi() {
		if(!move.nuocDi("black")) {
			return 1;
		}
		else if(!move.nuocDi("white")) {
			return -1;
		}
		return 0;
	}
	

}
