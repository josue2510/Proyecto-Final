package entity;

import java.util.Scanner;

import view.InputTypes;

public class DocenteIO {
	
	public static Docente ingresar(Scanner scanner) {
		int idPersona =
				InputTypes.readInt("ID Persona :", scanner);
		String nombre =
				InputTypes.readString("Nombre :", scanner);
		String email =
				InputTypes.readString("Email :", scanner);
		String direccion =
				InputTypes.readString("Direccion :", scanner);
		int idDocente =
				InputTypes.readInt("ID Docente :", scanner);
		String username =
				InputTypes.readString("Username :", scanner);
		String password =
				InputTypes.readString("Pass :", scanner);
		return new 
				Docente(idPersona,nombre,email,direccion,idDocente,username,password);
	}

}
