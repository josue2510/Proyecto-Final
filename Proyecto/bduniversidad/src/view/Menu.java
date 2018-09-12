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

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}


	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexi�n = new Conexion("root","","dbuniversidad");
		Agregar agregar = new Agregar(conexi�n, scanner);
		Consultas cons = new Consultas();
		
		//ProductosIO productosIO = new ProductosIO(conexi�n, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				MenuAgregar.men�(scanner, agregar);
				break;
			case 2:
				MenuListar.men�(scanner, cons);
				break;
		
			}
		}
		conexi�n.close();
	}

}
