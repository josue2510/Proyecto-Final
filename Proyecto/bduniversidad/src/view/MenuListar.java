package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import control.Consultas;
import entity.Clase;
import entity.Docente;
import entity.Estudiante;
import entity.Grupo;
import entity.Materia;
import entity.Pagos;
import entity.Persona;

public class MenuListar {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Listar Clases ");
			System.out.println("2. Listar Docentes ");
			System.out.println("3. Listar Estudiantes ");
			System.out.println("4. Listar Grupos ");
			System.out.println("5. Listar Materias ");
			System.out.println("6. Listar Pagos ");
			System.out.println("7. Listar Personas ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 7) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, Consultas cons) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				ArrayList<Clase> clases = cons.getClase();
				Iterator<Clase> it2 = clases.iterator();
				while (it2.hasNext()) {
					Clase c = it2.next();
					System.out.print(c.getIdEstudiante() + " " + c.getIdGrupo() + " " + c.getNota() );
					System.out.println();
					cons.getEstudiantes();
				}
				break;
			case 2:
				ArrayList<Docente> docentes = cons.getDocente();
				Iterator<Docente> it5 = docentes.iterator();
				while (it5.hasNext()) {
					Docente d = it5.next();
					System.out.print(d.getDireccion() + " " + d.getEmail() + " " + d.getIdDocente() + " "
							+ d.getIdPersona() + " " + d.getNombre() + " " + d.getPassword() + " " + d.getPassword());
					System.out.println();
					cons.getEstudiantes();
				}
				break;
			case 3:
				ArrayList<Estudiante> estudiantes = cons.getEstudiantes();
				Iterator<Estudiante> it6 = estudiantes.iterator();
				while (it6.hasNext()) {
					Estudiante e = it6.next();
					System.out.print(e.getDireccion() + " " + e.getEmail() + " " + e.getIdEstudiante() + " "
							+ e.getIdPersona() + " " + e.getNombre());
					System.out.println();
					cons.getEstudiantes();
				}
				break;
			case 4:
				ArrayList<Grupo> grupos = cons.getGrupo();
				Iterator<Grupo> it4 = grupos.iterator();
				while (it4.hasNext()) {
					Grupo g = it4.next();
					System.out.print(g.getIdGrupo() + " " + g.getIdMateria() + " " + g.getIdDocente() + " "
							+ g.getFechaInicio() + " " + g.getFechaFin());
					System.out.println();
				}
				break;
			case 5:
				ArrayList<Materia> materias = cons.getMateria();
				Iterator<Materia> it = materias.iterator();
				while (it.hasNext()) {
					Materia m = it.next();
					System.out.print(m.getIdMateria() + " " + m.getNombre() + " " + m.getCostoCreditos() + " "
							+ m.getDuracion_dias());
					System.out.println();
				}
				break;
			case 6:
				ArrayList<Pagos> pagos = cons.getPagos();
				Iterator<Pagos> it1 = pagos.iterator();
				while (it1.hasNext()) {
					Pagos p = it1.next();
					System.out.print(
							p.getIdPago() + " " + p.getCreditos() + " " + p.getCosto() + " " + p.getIdEstudiante());
					System.out.println();
				}
				break;
			case 7:
				ArrayList<Persona> personas = cons.getPersona();
				Iterator<Persona> it3 = personas.iterator();
				while (it3.hasNext()) {
					Persona p = it3.next();
					System.out.print(
							p.getIdPersona() + " " + p.getNombre() + " " + p.getEmail() + " " + p.getDireccion());
					System.out.println();
					break;
				}
			}
		}

	}
}
