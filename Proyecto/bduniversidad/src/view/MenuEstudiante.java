package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import control.Consultas;

public class MenuEstudiante {
	Scanner scanner = new Scanner(System.in);
	Consultas cons = new Consultas();
	public MenuEstudiante()
	{
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
			MenuClasesCursadasActualmente();
			break;
		case 4:
			MateriasAlumnoPasadas();
			
			break;
		case 5:
			MenuNotas();
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
	
	private void MenuNotas() {
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
		MenuEstudiante m = new MenuEstudiante();
	}

	private void MenuClasesCursadasActualmente() {
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
		MenuEstudiante m = new MenuEstudiante();
	}
	
	private void MateriasAlumnoPasadas() {
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
		MenuEstudiante m = new MenuEstudiante();
	}
	
	private void MenuMostrarBalance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca ID");
		int idEstudiante = sc.nextInt();
		String[] res = cons.getBalance(idEstudiante);
		System.out.println("El balance de el estudiante " + res[0] + " es: " + res[1] + " creditos");
		System.out.println("Escriba algo para continuar");
		sc.next();
		MenuEstudiante m = new MenuEstudiante();
	}
	
}
