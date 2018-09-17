package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import control.Consultas;
import entity.Materia;
import entity.Pagos;

public class MenuEstudiante {
	Scanner scanner = new Scanner(System.in);
	Consultas cons = new Consultas();
	public MenuEstudiante() throws SQLException,ClassNotFoundException
	{
		System.out.println("Elija una opcion: ");
		System.out.println("--------------------------------");
		System.out.println("1.Mostrar balance o estado de cuenta");
		System.out.println("2.Mostrar Pagos Realizados");
		System.out.println("3.Mostrar Clases cursadas Actualmente");
		System.out.println("4.Mostrar Clases ya pasadas");
		System.out.println("5.Mostrar Notas");
		System.out.println("6.Mostrar Coste Materias");
		System.out.println("0.Salir");
		int eleccion = scanner.nextInt();
		switch (eleccion) {
		case 1:
			MenuMostrarBalance();
			break;
		case 2:
			MenuMostrarPagos();
			break;
		case 3:
			MenuClasesCursadasActualmente();
			break;
		case 4:
			MateriasAlumnoPasadas();
			break;
		case 5:
			MenuNotas();
			break;
		case 6:
			ArrayList<Materia> materias = cons.getMateria();
			Iterator<Materia> it = materias.iterator();
			while (it.hasNext()) {
				Materia m = it.next();
				System.out.print(m.getIdMateria() + " " + m.getNombre() + " " + m.getCostoCreditos());
				System.out.println();
			}
			break;
		
		case 0:
			new MenuPrincipal();
			break;

		default:
			break;
		}
	}
	
	private void MenuNotas() throws SQLException, ClassNotFoundException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduzca ID");
		int idEstudiante = sc.nextInt();
		ArrayList<String[]> clases = cons.getNotasEstudiantes(idEstudiante);
		Iterator<String[]> it= clases.iterator();
		while(it.hasNext()) {
			String[] clase = it.next();
			System.out.println(clase[0]+"/"+clase[1]+"/"+clase[2]);
		}
		System.out.println("\n");
		System.out.println("Escriba algo para continuar");
		sc.next();
		System.out.println("\n");
		new MenuEstudiante();
	}

	private void MenuClasesCursadasActualmente() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca ID");
		int idEstudiante = sc.nextInt();
		ArrayList<String[]> clases = cons.getMateriasAlumnoActuales(idEstudiante);
		Iterator<String[]> it = clases.iterator();
		while(it.hasNext())
		{
			String[] clase = it.next();
			System.out.println(clase[0]+"/"+clase[1]+"/"+clase[2]);
		}
		System.out.println("Escriba algo para continuar");
		sc.next();
		new MenuEstudiante();
	}
	
	private void MateriasAlumnoPasadas() throws SQLException, ClassNotFoundException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduzca ID");
		int idEstudiante = sc.nextInt();
		ArrayList<String[]> clases=cons.getMateriasAlumnoPasadas(idEstudiante);
		Iterator<String[]> it = clases.iterator();
		while(it.hasNext()) {
			String[] clase=it.next();
			System.out.println(clase[0]+"/"+clase[1]+"/"+clase[2]);
		}
		System.out.println("Escriba algo para continuar");
		sc.next();
		new MenuEstudiante();
	}
	
	private void MenuMostrarBalance() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca ID");
		int idEstudiante = sc.nextInt();
		String[] res = cons.getBalance(idEstudiante);
		System.out.println("El balance de el estudiante " + res[0] + " es: " + res[1] + " creditos");
		System.out.println("Escriba algo para continuar");
		sc.next();
		new MenuEstudiante();
	}
	private void MenuMostrarPagos()throws SQLException, ClassNotFoundException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca ID");
		int idEstudiante = sc.nextInt();
		String[] res = cons.PagosEstudiante(idEstudiante);
		System.out.println("Los pagos del estudiante son " + res[0] + "son :" +res[1] + "creditos");
		System.out.println("Escriba algo para continuar");
		sc.next();
		new MenuEstudiante();
	}

	
}
