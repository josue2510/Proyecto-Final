package view;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import control.Agregar;
import control.Consultas;
import entity.Docente;

public class MenuPrincipal {
	Scanner scanner = new Scanner(System.in);
	Consultas cons = new Consultas();

	public MenuPrincipal() {

		System.out.println("Elija una opcion: ");
		System.out.println("--------------------------------");
		System.out.println("1. Ingreso Estudiante");
		System.out.println("2. Ingreso Docente");
		System.out.println("0. Salir");
		int eleccion = scanner.nextInt();
		switch (eleccion) {
		case 1:
			MenuEstudiante m = new MenuEstudiante();
			break;
		case 2:
			MenuDocente();
			break;
		case 0:
			try {
				cons.con.getInstance().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	private void MenuDocente() {
		int opcion;
		boolean aceptado = false;
		Scanner sc = new Scanner(System.in);
		while (!aceptado) {
			System.out.println("Introduzca usuario");
			String usuario = sc.nextLine();
			System.out.println("Introduzca contrasena");
			String contrasena = sc.nextLine();
			Docente docente = cons.getUserPassword(usuario, contrasena);

			if (docente.getIdDocente() == 0) {
				System.out.println("Vuelva a introducir los datos");
			}

			else {
				aceptado = true;
			}
		}

		System.out.println("Ingrese una opcion: ");
		System.out.println("------------------- ");
		System.out.println("1. Agregar ");
		System.out.println("2. Listar");
		System.out.println("0. Salir");
		System.out.println();

		opcion = InputTypes.readInt("¿Su opción? ", scanner);
		try {
			Conexion conexión = new Conexion("root", "", "dbuniversidad");
			Agregar agregar = new Agregar(conexión, scanner);
			switch (opcion) {
			case 0:
				MenuPrincipal m = new MenuPrincipal();
				break;
			case 1:
				MenuAgregar.menú(scanner, agregar);
				break;
			case 2:
				MenuListar.menú(scanner, cons);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}