package entity;

import java.util.Scanner;

import view.InputTypes;

public class ClaseIO {
	
	public static Clase Ingresar(Scanner scanner) {
		int idGrupo =
				InputTypes.readInt("ID Grupo", scanner);
		int idEstudiante =
				InputTypes.readInt("ID Estudiante", scanner);
		int nota =
				InputTypes.readInt("Nota", scanner);
		return new 
				Clase(idGrupo,idEstudiante,nota);
		
	}

}
