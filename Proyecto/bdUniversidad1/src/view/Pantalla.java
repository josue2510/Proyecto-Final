package view;

import java.util.ArrayList;
import java.util.Iterator;

import conexion.Consultas;
import entity.Estudiante;
import entity.Materia;
import entity.Pagos;

public class Pantalla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Consultas cons= new Consultas();
		
		ArrayList<Materia> materias = cons.getMateria();
		Iterator<Materia> it = materias.iterator();
		while(it.hasNext()) {
			Materia m=it.next();
			System.out.print(m.getIdMateria()+" "+m.getNombre()+" "+m.getCostoCreditos()+" "
			+m.getDuracion_dias());
			System.out.println();
			
		
		}
		
		ArrayList<Estudiante> estudiantes=cons.getEstudiantes();
		Iterator<Estudiante> it2 = estudiantes.iterator();
		while(it2.hasNext()) {
			Estudiante Est=it2.next();
			System.out.print(Est.getIdEstudiante()+" "+ Est.getIdPersona()+" "
			+ Est.getNombre()+" "+ Est.getEmail()+" "+ Est.getDireccion());
			System.out.println();
		}
		
		ArrayList<Pagos> pagados=cons.getPagos();
		Iterator<Pagos> it3 = pagados.iterator();
		while(it3.hasNext()) {
			Pagos pag= it3.next();
			System.out.print(pag.getIdPago()+" "+ pag.getIdEstudiante()+ " "+ pag.getCreditos()+" "
			+ pag.getCosto());
			System.out.println();
		}
	}

}
