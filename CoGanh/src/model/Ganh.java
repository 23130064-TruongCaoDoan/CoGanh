package model;

public class Ganh {

	public int anGanh(int fX, int fY, int toX, int toY, String currentColor, Board b) {
		String enemy = currentColor.equals("white") ? "black" : "white";
		int capturedCount = 0;

		int[][] dirs1 = { { 0, -1, 0, 1 }, { -1, 0, 1, 0 }, };

		int[][] dirs2 = { { -1, -1, 1, 1 }, { -1, 1, 1, -1 } };

		for (int[] d : dirs1) {
			int r1 = toX + d[0], c1 = toY + d[1];
			int r2 = toX + d[2], c2 = toY + d[3];
			if (b.inBoard(r1, c1) && b.inBoard(r2, c2)) {
				if (b.isColorMatch(r1, c1, enemy) && b.isColorMatch(r2, c2, enemy)) {
				if (!b.getPiece(r1, c1).getColor().equals("emty")) {
						capturedCount++;
					}
					if (!b.getPiece(r2, c2).getColor().equals("emty")) {
						capturedCount++;
					}
					b.getPiece(r1, c1).setColor("emty");
					b.getPiece(r2, c2).setColor("emty");
				}
			}
		}

		if (checkGanhCheo(toX, toY)) {
			for (int[] d : dirs2) {
				int r1 = toX + d[0], c1 = toY + d[1];
				int r2 = toX + d[2], c2 = toY + d[3];
				if (b.inBoard(r1, c1) && b.inBoard(r2, c2)) {
					if (b.isColorMatch(r1, c1, enemy) && b.isColorMatch(r2, c2, enemy)) {
					if (!b.getPiece(r1, c1).getColor().equals("emty")) {
							capturedCount++;
						}
						if (!b.getPiece(r2, c2).getColor().equals("emty")) {
							capturedCount++;
						}
						b.getPiece(r1, c1).setColor("emty");
						b.getPiece(r2, c2).setColor("emty");
					}
				}
			}
		}
		return capturedCount;
	}
public boolean checkGanhCheo(int toX, int toY) {
	if ((toX == 1 && toY == 1) || (toX == 1 && toY == 3) || (toX == 2 && toY == 2)
			|| (toX == 3 && toY == 1) || (toX == 3 && toY == 3)) {
		return true;
	}
	return false;
}
}