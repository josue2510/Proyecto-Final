package control;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import entity.Clase;
import entity.ClaseIO;
import entity.Docente;
import entity.DocenteIO;
import entity.Estudiante;
import entity.EstudianteIO;
import entity.Grupo;
import entity.GrupoIO;
import entity.Materia;
import entity.MateriaIO;
import entity.Pagos;
import entity.PagosIO;
import entity.Persona;
import entity.PersonaIO;

public class Agregar {
	private Conexion con;
	private Scanner scanner;
	
	public Agregar(Conexion con, Scanner scanner) {
		this.con = con;
		this.scanner = scanner;
	}

	public void addmateria(){
		Materia materia = MateriaIO.ingresar(scanner);
		String sql = "INSERT INTO materia ( Nombre, CostoCreditos, Duracion_Dias) " + 
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
	public void addDocente() {
		Docente docente = DocenteIO.ingresar(scanner);
		String sql = "INSERT INTO docente ( IDpersona, Username, Password)\r\n" + 
				"  VALUES ( ?, '?', '?')";
		try {
			con.consulta(sql);
			con.getSentencia().setInt(1, docente.getIdPersona());
			con.getSentencia().setString(2, docente.getUsername());
			con.getSentencia().setString(3, docente.getPassword());
			con.modificacion();
		}catch(SQLException e) {
			System.out.println(e.getSQLState());
		}
				}
	public void addPersona() {
		Persona persona = PersonaIO.igresar(scanner);
		String sql = "INSERT INTO persona ( Nombre, Email, Direccion)\r\n" + 
				"  VALUES ('?', '?', '?')";
		try {
			con.consulta(sql);
			con.getSentencia().setString(1, persona.getNombre());
			con.getSentencia().setString(2, persona.getEmail());
			con.getSentencia().setString(3, persona.getDireccion());
			con.modificacion();
		}catch(SQLException e) {
			System.out.println(e.getSQLState());
		}
		
	}
	public void addEstudinate() {
		Estudiante estudiante = EstudianteIO.ingresar(scanner);
		String sql ="INSERT INTO estudiante ( IDpersona)\r\n" + 
				"  VALUES ( ?)";
		try {
			con.consulta(sql);
			con.getSentencia().setInt(1, estudiante.getIdPersona());
			con.modificacion();
			
		}catch(SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	public void addPagos() {
		Pagos pagos = PagosIO.ingresar(scanner);
		String sql = "INSERT INTO pagos ( IDestudiante, Creditos, Costo)\r\n" + 
				"  VALUES ( ?, ?, ?)";
		try {
			con.consulta(sql);
			con.getSentencia().setInt(1, pagos.getIdEstudiante());
			con.getSentencia().setInt(2, pagos.getCreditos());
			con.getSentencia().setDouble(3, pagos.getCosto());
			con.modificacion();
		}catch(SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	public void addClase() {
		Clase clase = ClaseIO.Ingresar(scanner);
		String sql ="INSERT INTO clase (IDgrupo, IDestudiante, Nota)\r\n" + 
				"  VALUES (?, ?, ?)";
		try {
			con.consulta(sql);
			con.getSentencia().setInt(1, clase.getIdGrupo());
			con.getSentencia().setInt(2, clase.getIdEstudiante());
			con.getSentencia().setInt(3, clase.getNota());
			con.modificacion();
		}catch(SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

}
