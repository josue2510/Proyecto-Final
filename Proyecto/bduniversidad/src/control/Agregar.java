package control;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import entity.Grupo;
import entity.GrupoIO;
import entity.Materia;
import entity.MateriaIO;

public class Agregar {
	private Conexion con;
	private Scanner scanner;
	
	public Agregar(Conexion con, Scanner scanner) {
		this.con = con;
		this.scanner = scanner;
	}

	public void addmateria(){
		Materia materia = MateriaIO.ingresar(scanner);
		String sql = "INSERT INTO materia ( Nombre, CostoCreditos, Duracion_Dias)\r\n" + 
				"  VALUES ( ?, ?, ?)";
		try {
			con.consulta(sql);
			con.getSentencia().setString(1, materia.getNombre());
			con.getSentencia().setInt(2, materia.getCostoCreditos());
			con.getSentencia().setInt(3, materia.getDuracion_dias());
			con.modificacion();
			
		}catch(SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	public void addgrupo() {
		Grupo grupo = GrupoIO.ingresar(scanner);
		String sql ="INSERT INTO grupo ( IDmateria, IDdocente, FechaInicio, FechaFin)\r\n" + 
				"  VALUES ( ?, ?, DATE('?'), DATE('?'))";
		try {
			con.consulta(sql);
			con.getSentencia().setInt(1, grupo.getIdMateria());
			con.getSentencia().setInt(2, grupo.getIdDocente());
			con.getSentencia().setString(3, grupo.getFechaInicio());
			con.getSentencia().setString(4, grupo.getFechaFin());
			con.modificacion();
		}catch(SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

}
