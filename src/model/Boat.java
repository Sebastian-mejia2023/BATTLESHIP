package model;

public abstract class Boat {
	protected byte size;
	protected String name;
	protected byte[] values;

	public Boat(byte size, String name, byte[] values) {
		this.size = size;
		this.name = name;
		this.values = new byte[size];

		/* Inicializar todas las casillas como vivas (valor 1) */
		for (int i = 0; i < size; i++) {
			values[i] = 1;
		}
	}

	public byte[] getvalues() {
		return values;
	}

	public void parts() {

	}

	public String getName() {
		return name;
	}

	public byte getSize() {
		return size;
	}

	public boolean isSunken() {
		/* Si todas las partes están en 2, el barco está hundido */
		for (byte part : values) {
			if (part == 1) {
				return false; /* Hay partes vivas */
			}
		}
		return true; /* Todas las partes están hundidas */
	}

	public void hitPart(int index) {
		/* Simula un golpe a una parte específica del barco */
		if (index >= 0 && index < size && values[index] == 1) {
			values[index] = 2; /* Marca la parte como hundida */
		}
	}

	public abstract void Addboat1(Matrix matrix, byte x, byte y);

}