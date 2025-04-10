package ui; /*  Asegúrate de que esta línea esté presente */

import java.util.Scanner;
import model.Controller;

public class Executable {
	private static final Controller controller = new Controller();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		System.out.println("Ingresa tu nombre de usuario: ");
		String username = input.nextLine();
		controller.register(username);
		System.out.println("Usuario registrado: " + username);
		do {
			System.out.println(controller.getname((byte) 0) + " Bienvenid@ a Battleship\n");
			System.out.println("Elije una de las siguientes opciones\n");
			System.out.println("(1). Jugar");
			System.out.println("(2). Salir");
			byte option = input.nextByte();
			/* clear buffer */
			input.nextLine();
			switch (option) {
				case 1:

					byte option2;
					System.out.println("ELIJE EL MODO DE JUEGO \n (1). estandar \n (2). personalizado ");
					option2 = input.nextByte();
					switch (option2) {
						case 1:
							while (true) {

								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco tipo lancha");
								System.out.println("ingresa la coordenada X o el numero de la columna");
								byte x1 = input.nextByte();
								System.out.println("ingresa la coordenada Y o el numero de la fila");
								byte y1 = input.nextByte();

								if (!controller.addboat1((byte) 0, x1, y1)) {
									System.out.println("\n barco añadido con exito \n");
									System.out.println("tu lista de barcos es " + controller.getlistboats((byte) 0));
									break;
								} else {
									System.out.println(" \n coordenada invalida intentalo de nuevo \n ");
								}

							}
							/* barco medico */

							while (true) {

								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco tipo Medico (vertical, 2 unidades)");
								System.out.println("ingresa la coordenada X o el numero de la columna");
								byte x1 = input.nextByte();
								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira una de las partes del barco");
								byte y1 = input.nextByte();
								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira la otra parte del barco");
								byte y2 = input.nextByte();
								if (!controller.addboat2((byte) 0, x1, (byte) 0, y1, y2, true)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;
								} else {
									System.out.println("\n coordenada invalida \n ");
								}

							}

							while (true) {
								System.out.println(controller.getname((byte) 0)
										+ controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco de proviciones (horizontal) ");
								System.out.println(
										"ingresa la coordenada X donde ira una  de las 2 puntas del barcos  el numero de la columna");
								byte x1 = input.nextByte();

								System.out.println("ingresa la coordenada X donde  el numero de la columna");
								byte x2 = input.nextByte();

								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira la otra parte del barco");
								byte y1 = input.nextByte();

								boolean vertical = false;
								if (!controller.addboat3((byte) 0, x1, x2, y1, y1, vertical)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;

								} else {
									System.out.println("Coordenada invalida");
								}

							}

							while (true) {
								System.out.println(controller.getname((byte) 0)
										+ controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco de Municiones (vertical) ");
								System.out.println(
										"ingresa la coordenada X o el numero de la columna donde estara ubicado el barco");
								byte x1 = input.nextByte();

								System.out.println("ingresa la coordenada Y donde estara una de las puntas del barco ");
								byte y1 = input.nextByte();

								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira la otra parte del barco");
								byte y2 = input.nextByte();

								boolean vertical = true;
								if (!controller.addboat3((byte) 0, x1, x1, y1, y2, vertical)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;

								} else {
									System.out.println("Coordenada invalida");
								}

							}

							break;
						case 2:

							break;

						default:
							System.out.println("opcion no");
					}
					break;
				case 2:
					run = false; // Cambia run a false para salir del bucle
					break;
				default:
					System.out.println("Opción no válida. Intenta de nuevo.");
			}

		} while (run);
	}
}