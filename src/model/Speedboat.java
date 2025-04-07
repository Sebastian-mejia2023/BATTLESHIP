package model;

public class Speedboat extends Boat {
	private byte x;
	private byte y;
	private byte[] values;

	public Speedboat() {
		super((byte) 1, "Lancha", new byte[1]); // pasas un array nuevo directamente
		this.values = new byte[1]; // y también lo guardas en tu propia variable
	}

	public byte[] getvalues() {
		return values;
	}

	public void setPosition(byte x, byte y) {
		this.x = x;
		this.y = y;
	}

	public byte getX() {
		return x;
	}

	public byte getY() {
		return y;
	}

	@Override
	public void Addboat1(Matrix matrix, byte x, byte y) {
		matrix.addBoat1(x, y);
		matrix.getMatrix();
	}
}
