package ui; // Asegúrate de que esta línea esté presente

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
					System.out.println("ELIJE EL MODO DE JUEGO \n (1). estandar n/ (2). personalizado ");
					option2 = input.nextByte();
					switch (option2) {
						case 1:
							while (true) {

								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco tipo lancha");
								System.out.println("ingresa la coordenada X o el numero de la columna");
								byte x = input.nextByte();
								System.out.println("ingresa la coordenada Y o el numero de la fila");
								byte y = input.nextByte();

								controller.addboat1((byte) 0, x, y);

								break;

							}
							System.out.println("barco ubicado con exito ");
							/* barco medico */
							for (byte a = 0; a <= 1; a++) {
								while (true) {

									System.out.println(controller.getname((byte) 0)
											+ " ingresa las coordenadas para ubicar El barco tipo Medico");
									System.out.println("ingresa la coordenada X o el numero de la columna");
									byte x = input.nextByte();
									System.out.println(
											"ingresa la coordenada Y o el numero de la fila donde ira una de las partes del barco");
									byte y1 = input.nextByte();
									System.out.println(
											"ingresa la coordenada Y o el numero de la fila donde ira la otra parte del barco");
									byte y2 = input.nextByte();
									if (!controller.addboat2((byte) 0, x, y1, y2)) {
										System.out.println("barco añadido con exito");
										break;
									}
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