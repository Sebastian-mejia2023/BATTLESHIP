package model;

import java.util.ArrayList;

public class Controller {
	Player[] playerslist = new Player[2];
	ArrayList<Boat> boats = new ArrayList<>();

	/* metodos de inicializacion */
	public void register(String username) {
		byte points_user = 0;
		playerslist[0] = new Player(username, points_user, new Matrix(), boats);
	}

	/* metodos de player */
	public String getname(byte user) {
		return playerslist[user].getName();
	}

	public byte getpoins(byte user) {
		return playerslist[user].getPoints();
	}

	public Matrix getmatrix(byte user) {
		// Validar que el índice del usuario esté dentro de los límites
		if (user < 0 || user >= playerslist.length) {
			System.out.println("Usuario no válido");
			return null; // O lanzar una excepción, dependiendo de cómo quieras manejarlo
		}
		return playerslist[user].getMatrix();
	}

	public ArrayList<Boat> getlist() {
		return playerslist[0].geList();
	}

	/* metodos de speadboat */

	public boolean addboat1(byte user, byte x, byte y) {
		if ((x <= 10 && x > 0) && (y <= 10 && y > 0)) {
			x--;
			y--;

			Speedboat speedboat = new Speedboat();

			if (playerslist[user].getMatrix().getValue(x, y) == 0) {
				speedboat.Addboat1(playerslist[user].getMatrix(), x, y); // Llama al método addboat1 de Speedboat
				playerslist[user].geList().add(speedboat);
				return false;
			} else {
				System.out.println("posicion ya Ocupada");
				return true;
			}
		} else {
			System.out.println("coordenada invalida");
			return true;
		}

	}

	public boolean addboat2(byte user, byte x, byte y1, byte y2) {

		Medicalship medicalship = new Medicalship();
		if (((x <= 10 && x > 0) && (y1 <= 10 && y1 > 0) && (y2 <= 10 && y2 > 0))
				&& ((y1 - y2 == 1) || (y1 - y2 == -1))) {
			x--;
			y1--;
			y2--;
			if (playerslist[user].getMatrix().getValue(x, y1) == 0
					&& playerslist[user].getMatrix().getValue(x, y2) == 0) {

				medicalship.addboat2(playerslist[user].getMatrix(), x, y1, y2);
				playerslist[user].geList().add(medicalship);
				return false;
			} else {
				System.out.println("posicion ya ocupada");
				return true;
			}

		} else {
			System.out.println("coordenada invalida");
			return true;
		}

	}

	/* metodos matrix */
	public byte getvalue(byte x, byte y) {
		return playerslist[0].getMatrix().getValue(x, y);

	}

}