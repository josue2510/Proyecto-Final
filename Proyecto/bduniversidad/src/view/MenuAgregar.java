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
			System.out.println("2. Listar Categor�as ");
			System.out.println("3. Eliminar Categor�a ");
			System.out.println("4. Modificar Categor�a ");
			System.out.println("5. Productos por Categor�a ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}
	
	public static void men�(Scanner scanner, Agregar add) throws SQLException {
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
				break;
			case 3:
				
				break;

			case 4:
				
				break;

			case 5:
				
				break;
			}
		}
	}

}
