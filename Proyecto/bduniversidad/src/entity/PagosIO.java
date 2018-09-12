package entity;

import java.util.Scanner;

import view.InputTypes;

public class PagosIO {
	
	public static Pagos ingresar(Scanner scanner) {
		int idPago =
				InputTypes.readInt("ID Pago :", scanner);
		int creditos =
				InputTypes.readInt("Creditos :", scanner);
		double costo =
				InputTypes.readDouble("Costo :", scanner);
		int idEstudiante = 
				InputTypes.readInt("ID Estudiante", scanner);
		return new
				Pagos(idPago,creditos,costo,idEstudiante);
		
	}

}
