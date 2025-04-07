package model;

public class Medicalship extends Boat {
	private byte x;
	private byte y1;
	private byte y2;
	private byte[] values;

	public Medicalship() {
		super((byte) 2, " MEDICO ", new byte[2]);
		this.values = new byte[2];
		this.x = x;
		this.y1 = y1;
		this.y2 = y2;

		for (int i = 0; i < 2; i++) {
			values[i] = 1;
		}

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

	@Override
	public boolean isSunken() {
		// TODO Auto-generated method stub
		return super.isSunken();
	}

	@Override
	public void Addboat1(Matrix matrix, byte x, byte y) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'Addboat1'");

	}

	public void addboat2(Matrix matrix, byte x, byte y1, byte y2) {
		matrix.addBoat1(x, y1);
		matrix.addBoat1(x, y2);
		matrix.getMatrix();

	}

}
