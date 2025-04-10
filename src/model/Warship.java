package model;

import java.util.ArrayList;

public class Warship extends Boat {
	private boolean vertical;
	private ArrayList<Byte> valuesX;
	private ArrayList<Byte> valuesY;

	public Warship(byte size, String name, boolean vertical) {
		super(size, name);
		this.vertical = vertical;
		this.valuesX = new ArrayList<Byte>();
		this.valuesY = new ArrayList<Byte>();

	}

	@Override
	public void Addboat1(Matrix matrix, byte x, byte y) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'Addboat1'");
	}

	public void addboat4(Matrix matrix, byte x, byte y) {
		matrix.addBoat1(x, y);
		valuesX.add(x);
		valuesY.add(y);
		matrix.getMatrix();
	}
}
