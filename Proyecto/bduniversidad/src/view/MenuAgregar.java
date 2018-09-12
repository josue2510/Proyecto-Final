package view;

import java.sql.SQLException;
import java.util.Scanner;


import control.Agregar;

public class MenuAgregar {
	
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Agregar Materia");
			System.out.println("2. Agregar Grupo");
			System.out.println("3. Agregar Docente");
			System.out.println("4. Agregar Persona");
			System.out.println("5. Agregar Estudiante");
			System.out.println("6. Agregar Pagos");
			System.out.println("7. Agregar Clase");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 7) {
				return opcion;
			}
		}
	}
	
	public static void menú(Scanner scanner, Agregar add) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				add.addmateria();
				break;
			case 2:
				add.addgrupo();
				break;
			case 3:
				add.addDocente();
				break;
			case 4:
				add.addPersona();
				break;
			case 5:
				add.addEstudinate();
				break;
			case 6:
				add.addPagos();
				break;
			case 7:
				add.addClase();
				break;
			}
		}
	}

}
