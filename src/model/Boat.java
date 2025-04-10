package model;

public abstract class Boat {
	protected byte size;
	protected String name;

	public Boat(byte size, String name) {
		this.size = size;
		this.size = size;

		/* Inicializar todas las casillas como vivas (valor 1) */

	}

	public void setname(String name) {
		this.name = name;
	}

	public void parts() {

	}

	public String getName() {
		return name;
	}

	public byte getSize() {
		return size;
	}

	public abstract void Addboat1(Matrix matrix, byte x, byte y);

}