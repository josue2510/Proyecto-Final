package entity;

import java.util.Scanner;

import view.InputTypes;

public class EstudianteIO {
	
	public static Estudiante ingresar(Scanner scanner) {
		int idPersona =
				InputTypes.readInt("ID Persona :", scanner);
		String nombre =
				InputTypes.readString("Nombre :", scanner);
		String email = 
				InputTypes.readString("Email :", scanner);
		String direccion =
				InputTypes.readString("Direccion :", scanner);
		int idEstudiante =
				InputTypes.readInt("ID Estudinate", scanner);
		return new 
				Estudiante(idPersona,nombre,email,direccion,idEstudiante);
	}

}
