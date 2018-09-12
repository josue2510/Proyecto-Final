package entity;

import java.util.Scanner;

import view.InputTypes;

public class PersonaIO {
	
	public static Persona igresar(Scanner scanner) {
		int idPersona =
				InputTypes.readInt("ID Persona :", scanner);
		String nombre = 
				InputTypes.readString("Nombre :", scanner);
		String email =
				InputTypes.readString("Email :", scanner);
		String direccion =
				InputTypes.readString("Dreccion", scanner);
		return new 
				Persona(idPersona,nombre,email,direccion);
		
	}

}
