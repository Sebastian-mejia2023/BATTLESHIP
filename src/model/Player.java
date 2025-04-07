package model;

import java.util.ArrayList;

public class Player {
	private String name;
	private byte points;
	public Matrix matrix;
	public ArrayList<Boat> boats = new ArrayList<>();

	public Player(String name, byte points, Matrix matrix, ArrayList<Boat> boats) {
		this.name = name;
		this.points = points;
		this.matrix = matrix;
		this.boats = boats;
	}

	public ArrayList<Boat> geList() {
		return boats;
	}

	// Getters opcionales para acceder desde otras clases
	public String getName() {
		return name;
	}

	public byte getPoints() {
		return points;
	}

	public Matrix getMatrix() {
		return matrix;
	}

}
