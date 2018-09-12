package entity;

import java.util.Scanner;

import view.InputTypes;

public class GrupoIO {
	
	public static Grupo ingresar(Scanner scanner) {
		int idGrupo =
				InputTypes.readInt("ID Grupo :", scanner);
		int idMateria = 
				InputTypes.readInt("ID Materia :", scanner);
		int idDocente = 
				InputTypes.readInt("ID Docente :", scanner);
		String fechaInicio = 
				InputTypes.readString("Fecha Inicio(año/mes/dia) :", scanner);
		String fechaFin =
				InputTypes.readString("Fecha Fin(año/mes/dia) : ", scanner);
		return new 
				
				Grupo(idGrupo,idMateria,idDocente,fechaInicio,fechaFin);
				
	}

}
