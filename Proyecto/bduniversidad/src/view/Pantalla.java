package view;

import java.util.ArrayList;
import java.util.Iterator;

import conexion.Consultas;
import entity.Estudiante;
import entity.Materia;

public class Pantalla {

	public static void main(String[] args) {
		
		Consultas cons = new Consultas();
		ArrayList<Materia> materias = cons.getMateria();
		Iterator<Materia> it = materias.iterator();
		while(it.hasNext())
		{
			Materia m = it.next();
			System.out.print(m.getIdMateria()+" "+m.getNombre()+" "+m.getCostoCreditos()+" "+m.getDuracion_dias());
			System.out.println();
		}
		ArrayList<Estudiante> estudiantes = cons.getEstudiantes();
		Iterator<Estudiante> it2 = estudiantes.iterator();
		while(it2.hasNext()) {
			Estudiante e = it2.next();
			System.out.print(e.getDireccion()+" "+e.getEmail()+" "+e.getIdEstudiante()+" "+e.getIdPersona()+" "+e.getNombre());
			System.out.println();
		}
		
	}

}
