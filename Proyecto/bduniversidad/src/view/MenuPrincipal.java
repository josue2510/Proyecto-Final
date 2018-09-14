package view;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import control.Agregar;
import control.Consultas;
import entity.Docente;

public class MenuPrincipal {
	Scanner scanner;
	Consultas cons;

	public MenuPrincipal() {
		System.out.println("Elija una opcion: ");
		System.out.println("--------------------------------");
		System.out.println("1. Ingreso Estudiante");
		System.out.println("2. Ingreso Docente"); 
		System.out.println("0. Salir");
		int eleccion = scanner.nextInt();
		switch (eleccion) {
		case 1:
			MenuEstudiante();
			break;
		case 2:
            MenuDocente();
			break;
		case 0:
            
			break;

		default:
			break;
		}
	}

	private void MenuDocente() {
		Consultas cons = new Consultas();
		int opcion;
		while (true) {
			boolean aceptado = false;
			while(!aceptado)
			{
				System.out.println("Introduzca usuario");
				String usuario=scanner.nextLine();
				System.out.println("Introduzca contrasena");
				String contrasena = scanner.nextLine();
				Docente docente = cons.getUserPassword(usuario, contrasena);
				
				if(docente.getIdDocente()==0) {
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

			opcion = InputTypes.readInt("¿Su opción? ", scanner);
			try {
				Conexion conexión = new Conexion("root","","dbuniversidad");
				Agregar agregar = new Agregar(conexión, scanner);
				switch (opcion) {
				case 0:
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

	private void MenuEstudiante() {
		System.out.println("Elija una opcion: ");
		System.out.println("--------------------------------");
		System.out.println("1.Mostrar balance o estado de cuenta");
		System.out.println("2.Mostrar Pagos Realizados");
		System.out.println("3.Mostrar Clases cursadas Actualmente");
		System.out.println("4.Mostrar Clases ya pasadas");
		System.out.println("5.Mostrar Notas");
		System.out.println("6.Mostrar Pagos Realizados");
		System.out.println("7.Mostrar Coste Materias");
		System.out.println("0.Salir");
		int eleccion = scanner.nextInt();
		switch (eleccion) {
		case 1:
			MenuMostrarBalance();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 0:
			MenuPrincipal m = new MenuPrincipal();
			break;

		default:
			break;
		}
	}

	private void MenuMostrarBalance() {
		System.out.println("Introduzca ID");
		int idEstudiante = scanner.nextInt();
		String[] res = cons.getBalance(idEstudiante);
		System.out.println("El balance de el estudiante " + res[0] + " es: " + res[1] + " creditos");

	}
}