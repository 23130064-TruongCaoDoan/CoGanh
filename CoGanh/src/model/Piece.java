package model;

public class Piece {
	private String color;
	private int x, y;

	public Piece(String color, int x, int y) {
		super();
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
