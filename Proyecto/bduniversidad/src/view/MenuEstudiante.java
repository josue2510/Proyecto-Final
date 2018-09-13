package view;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import control.Agregar;
import control.Consultas;
import entity.Docente;
import entity.Estudiante;

public class MenuEstudiante {
	
	
	public static int encabezadoEstudiante(Scanner scanner) {
		int opcion;
		Consultas cons = new Consultas();

		while (true) {
			boolean aceptado = false;
			while(!aceptado)
			{
				System.out.println("Introduzca idEstudiante");
				int idEstudiante = scanner.nextInt();
				
				Estudiante estudiante = cons.getEstudiante(idEstudiante);
				
				if(estudiante.getIdEstudiante()==0) {
					System.out.println("Vuelva a introducir los datos");
					}
				
				else {
					aceptado=true;
				}
			}
			
			
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Agregar ");
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
			switch (encabezadoEstudiante(scanner)) {
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