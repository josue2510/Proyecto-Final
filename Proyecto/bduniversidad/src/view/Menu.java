package view;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import control.Agregar;
import control.Consultas;

public class Menu {
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar");
			System.out.println("2. Listar");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}


	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexión = new Conexion("root","","dbuniversidad");
		Agregar agregar = new Agregar(conexión, scanner);
		Consultas cons = new Consultas();
		
		//ProductosIO productosIO = new ProductosIO(conexión, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				MenuAgregar.menú(scanner, agregar);
				break;
			case 2:
				MenuListar.menú(scanner, cons);
				break;
		
			}
		}
		conexión.close();
	}

}
