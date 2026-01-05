package model;

public class Move {
	private Board b;
	private Ganh ganh;
	private Chet chet;

	public Move(Board b) {
		super();
		this.b = b;
		this.ganh = new Ganh();
		this.chet = new Chet();
	}

	public boolean diChuyen(int fX, int fY, int toX, int toY, String currentColor) {
		if (isMoveValid(fX, fY, toX, toY, currentColor)) {
			b.move(fX, fY, toX, toY);
			return true;
		}
		return false;
	}

	public int anQuan(int fX, int fY, int toX, int toY, String currentColor) {
		return ganh.anGanh(fX, fY, toX, toY, currentColor, b)+chet.anChet(fX, fY, toX, toY, currentColor, b);
	}

	public boolean nuocDi(String currentColor) {
		Piece[][] board = this.b.getBoard();

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (board[r][c].getColor().equals(currentColor)) {

					int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
					if (isDiagonalAllowed(r, c)) {
						dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
								{ 1, 1 } };
					}

					for (int[] d : dirs) {
						int nr = r + d[0];
						int nc = c + d[1];
						if (b.inBoard(nr, nc) && board[nr][nc].getColor().equals("emty")) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public boolean isDiagonalAllowed(int r, int c) {
		final int[][] choPhepCheo = { { 0, 0 }, { 0, 2 }, { 0, 4 }, { 1, 1 }, { 1, 3 }, { 2, 0 }, { 2, 2 }, { 2, 4 },
				{ 3, 1 }, { 3, 3 }, { 4, 0 }, { 4, 2 }, { 4, 4 } };

		for (int[] pos : choPhepCheo) {
			if (pos[0] == r && pos[1] == c) {
				return true;
			}
		}
		return false;
	}

	public boolean isMoveValid(int fX, int fY, int toX, int toY, String currentColor) {
		if (b.getPiece(fX, fY).getColor().equals("emty") || !b.getPiece(fX, fY).getColor().equals(currentColor)) {
			return false;
		}

		if (!b.inBoard(fX, fY) || !b.inBoard(toX, toY)) {
			return false;
		}

		if (!b.getPiece(toX, toY).getColor().equals("emty")) {
			return false;
		}
		int dr = Math.abs(toX - fX);
		int dc = Math.abs(toY - fY);

		if (dr > 1 || dc > 1 || (dr == 0 && dc == 0)) {
			return false;
		}

		boolean isDiagonalMove = (dr == 1 && dc == 1);

		if (isDiagonalMove) {
			if (!isDiagonalAllowed(fX, fY)) {
				return false;
			}
		}

		return true;
	}
}