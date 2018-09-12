package entity;

import java.util.Scanner;

import view.InputTypes;

public class MateriaIO {
	
	public static Materia ingresar(Scanner scanner) {
		int idMateria =
				InputTypes.readInt("ID Materia :", scanner);
		String nombre = 
				InputTypes.readString("Nombre de la Materia :", scanner);
		int costoCreditos =
				InputTypes.readInt("Costo Creditos :", scanner);
		int duracion_dias =
				InputTypes.readInt("Duracion en Dias :", scanner);
		return new 
				Materia(idMateria, nombre,costoCreditos,duracion_dias);
	}

}
