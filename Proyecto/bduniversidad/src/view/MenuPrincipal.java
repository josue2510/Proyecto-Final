package view;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import control.Agregar;
import control.Consultas;

public class MenuPrincipal {
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. ingreso Alumnos ");
			System.out.println("2. ingreso Docentes");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			
				switch (opcion) {
				case 0:
					break;
				case 1:
					MenuEstudiante.encabezadoEstudiante(scanner);
					break;
				case 2:
					MenuDocente.encabezadoDocente(scanner);
					break;
			
				
			}
		}
	}


	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexi�n = new Conexion("root","","dbuniversidad");
		
		
		//ProductosIO productosIO = new ProductosIO(conexi�n, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				MenuEstudiante.encabezadoEstudiante(scanner);
				break;
			case 2:
				MenuDocente.encabezadoDocente(scanner);
				break;
		
			}
		}
		conexi�n.close();
	}
}