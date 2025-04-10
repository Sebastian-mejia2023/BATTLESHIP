package model;

import java.util.ArrayList;

/**
 * 
 * quitar getmatrix del metodo añadir bote para que no se muestre la matriz de
 * la maquina
 * agregar despues del metodo añadir bote de subclase bote
 * 
 */
public class Controller {
	Player[] playerslist = new Player[2];
	ArrayList<Boat> boats = new ArrayList<>();

	/* metodos de inicializacion */
	public void register(String username) {
		byte points_user = 0;
		playerslist[0] = new Player(username, points_user, new Matrix(), boats);
	}

	public Player[] getplayerlist() {
		return playerslist;
	}

	public ArrayList<Boat> getlistboats(byte user) {
		return playerslist[user].getList();
	}

	/* metodos de player */
	public String getname(byte user) {
		return playerslist[user].getName();
	}

	public byte getpoins(byte user) {
		return playerslist[user].getPoints();
	}

	public Matrix getmatrix(byte user) {
		/* Validar que el índice del usuario esté dentro de los límites */
		if (user < 0 || user >= playerslist.length) {
			System.out.println("Usuario no válido");
			return null; // O lanzar una excepción, dependiendo de cómo quieras manejarlo
		}
		return playerslist[user].getMatrix();
	}

	/* metodos de speadboat */

	public boolean addboat1(byte user, byte x, byte y) {
		if ((x <= 10 && x > 0) && (y <= 10 && y > 0)) {
			x--;
			y--;
			/* parametros? */

			if (playerslist[user].getMatrix().getValue(x, y) == 0) {
				Speedboat speedboat = new Speedboat((byte) 1, " Lancha ");
				speedboat.Addboat1(playerslist[user].getMatrix(), x, y); /* Llama al método addboat1 de Speedboat */
				/* aqui iba */
				playerslist[user].getList().add(speedboat);
				playerslist[user].getMatrix();

				return false;
			} else {

				return true;
			}
		} else {

			return true;
		}

	}

	public boolean addboat2(byte user, byte x1, byte x2, byte y1, byte y2, boolean vertical) {
		if (vertical == true) {

			if (((x1 <= 10 && x1 > 0) && (y1 <= 10 && y1 > 0) && (y2 <= 10 && y2 > 0))
					&& ((y1 - y2 == 1) || (y1 - y2 == -1))) {
				x1--;
				y1--;
				y2--;
				if (playerslist[user].getMatrix().getValue(x1, y1) == 0
						&& playerslist[user].getMatrix().getValue(x1, y2) == 0) {

					Medicalship medicalship = new Medicalship((byte) 2, "Medico");

					medicalship.addboat2(playerslist[user].getMatrix(), x1, x2, y1, y2);
					playerslist[user].getList().add(medicalship);

					return false;
				} else {

					return true;
				}

			} else {

				return true;
			}
		} else {

			if (((y1 <= 10 && y1 > 0) && (x1 <= 10 && x1 > 0) && (x2 <= 10 && x2 > 0))
					&& ((x1 - x2 == 1) || (x1 - x2 == -1))) {
				Medicalship medicalship = new Medicalship((byte) 2, " Medico ");
				x1--;
				x2--;
				y1--;
				if (playerslist[user].getMatrix().getValue(y1, x1) == 0
						&& playerslist[user].getMatrix().getValue(y1, x2) == 0) {

					medicalship.addboat2(playerslist[user].getMatrix(), y1, y2, x1, x2);
					playerslist[user].getList().add(medicalship);
					return false;
				} else {

					return true;
				}

			} else {

				return true;
			}

		}

	}

	public boolean addboat3(byte user, byte x1, byte x2, byte y1, byte y2, boolean vertical) {
		if (vertical == true) {
			if (((x1 <= 10 && x1 > 0) && (y1 <= 10 && y1 > 0) && (y2 <= 10 && y2 > 0))
					&& ((y1 - y2 == 2) || (y1 - y2 == -2))) {
				x1--;
				y1--;
				y2--;
				if ((playerslist[user].getMatrix().getValue(x1, y1) == 0
						&& playerslist[user].getMatrix().getValue(x1, y2) == 0)
						&& playerslist[user].getMatrix().getValue(x1, (byte) (y1 + 1)) == 0) {
					Strategicship strategicship = new Strategicship((byte) 3, "noise", vertical);
					for (byte a = y1; a <= y2; a++) {
						strategicship.addboat3(playerslist[user].getMatrix(), x1, a);
					}
					playerslist[user].getList().add(strategicship);
					return false;

				} else {
					return true;

				}

			} else {
				return true;
			}

		} else {
			if (((y1 <= 10 && y1 > 0) && (x1 <= 10 && x1 > 0) && (x2 <= 10 && x2 > 0))
					&& ((x1 - x2 == 2) || (x1 - x2 == -2))) {
				y1--;
				x1--;
				x2--;
				if ((playerslist[user].getMatrix().getValue(x1, y1) == 0
						&& playerslist[user].getMatrix().getValue(x2, y1) == 0)
						&& playerslist[user].getMatrix().getValue((byte) (x1 + 1), y1) == 0) {
					Strategicship strategicship = new Strategicship((byte) 3, " BARCO DE PROVICIONES ", vertical);
					for (byte a = x1; a <= x2; a++) {
						strategicship.addboat3(playerslist[user].getMatrix(), a, y1);
					}
					playerslist[user].getList().add(strategicship);
					return false;

				} else {
					return true;
				}
			} else {
				return true;
			}

		}

	}

	/* metodos matrix */
	public byte getvalue(byte x, byte y) {
		return playerslist[0].getMatrix().getValue(x, y);

	}

}