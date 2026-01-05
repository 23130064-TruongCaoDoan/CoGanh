package model;

public class Chet {
	public int anChet(int fX, int fY, int toX, int toY, String currentColor, Board b) {
		String enemy = currentColor.equals("white") ? "black" : "white";
		int capturedCount = 0;

		int[][] dirs1 = {

				{ 0, -1, 0, -2 }, { 0, 1, 0, 2 }, { -1, 0, -2, 0 }, { 1, 0, 2, 0 }, };

		int[][] dirs2 = { { -1, -1, -2, -2 }, { 1, 1, 2, 2 }, { -1, 1, -2, 2 }, { 1, -1, 2, -2 } };

		for (int[] d : dirs1) {
			int r_o = toX + d[0], c_o = toY + d[1];
			int r_x = toX + d[2], c_x = toY + d[3];

			if (b.inBoard(r_o, c_o) && b.inBoard(r_x, c_x)) {
				if (b.isColorMatch(r_o, c_o, enemy) && b.isColorMatch(r_x, c_x, currentColor)) {
					if (!b.getPiece(r_o, c_o).getColor().equals("emty")) {
						capturedCount++;
					}
					b.getPiece(r_o, c_o).setColor("emty");
				}
			}
		}

		if (checkChetCheo(toX, toY)) {

			for (int[] d : dirs2) {
				int r_o = toX + d[0], c_o = toY + d[1];
				int r_x = toX + d[2], c_x = toY + d[3];

				if (b.inBoard(r_o, c_o) && b.inBoard(r_x, c_x)) {
					if (b.isColorMatch(r_o, c_o, enemy) && b.isColorMatch(r_x, c_x, currentColor)) {
						if (!b.getPiece(r_o, c_o).getColor().equals("emty")) {
							capturedCount++;
						}
						b.getPiece(r_o, c_o).setColor("emty");
					}
				}
			}
		}
		return capturedCount;
	}

	public boolean checkChetCheo(int toX,int toY) {
		if ((toX == 1 && toY == 1) || (toX == 1 && toY == 3) || (toX == 2 && toY == 2) || (toX == 3 && toY == 1)
				|| (toX == 3 && toY == 3)||(toX == 0 && toY == 0)||(toX == 0 && toY == 2)||(toX == 2 && toY == 0)||(toX == 2 && toY == 4)||(toX == 4 && toY == 0)||(toX == 0 && toY == 4)||(toX == 4 && toY == 2)||(toX == 4 && toY == 4)) {
			return true;
		}
		return false;
	}

}