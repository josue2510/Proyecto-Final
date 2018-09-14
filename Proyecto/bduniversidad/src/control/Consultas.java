
package control;

import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;

import entity.Clase;
import entity.Docente;
import entity.Estudiante;
import entity.Grupo;
import entity.Materia;
import entity.Pagos;
import entity.Persona;

public class Consultas {
	Conexion con;

	public Consultas() {
	}

	public ArrayList<Materia> getMateria() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT * FROM materia ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idMateria = rs.getInt(1);
				String nombre = rs.getString(2);
				int costo = rs.getInt(3);
				int duracionDias = rs.getInt(4);
				Materia m = new Materia(idMateria, nombre, costo, duracionDias);
				materias.add(m);
			}
		} catch (Exception e) {
		}

		return materias;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT IDestudiante,estudiante.IDpersona,nombre,email,direccion\r\n"
					+ "    FROM estudiante,persona\r\n" + "    WHERE persona.IDpersona = estudiante.IDpersona";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idestudiante = rs.getInt(1);
				int idpersona = rs.getInt(2);
				String nombre = rs.getString(3);
				String email = rs.getString(4);
				String direccion = rs.getString(5);

				Estudiante e = new Estudiante(idpersona, nombre, email, direccion, idestudiante);
				estudiantes.add(e);
			}
		} catch (Exception e) {
		}
		return estudiantes;
	}

	public ArrayList<Docente> getDocente() {
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT d.IDpersona,d.Username,d.Password,p.Nombre,d.IDdocente,p.Email,p.Direccion\r\n"
					+ "    FROM docente d INNER JOIN  persona p\r\n" + "    ON d.IDpersona = p.IDpersona";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idPersona = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String nombre = rs.getString(4);
				int idDocente = rs.getInt(5);
				String email = rs.getString(6);
				String direccion = rs.getString(7);

				Docente d = new Docente(idPersona, nombre, email, direccion, idDocente, username, password);
				docentes.add(d);
			}

		} catch (Exception e) {
		}
		return docentes;

	}

	public ArrayList<Grupo> getGrupo() {
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "    FROM grupo";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idGrupo = rs.getInt(1);
				int idMateria = rs.getInt(2);
				int idDocente = rs.getInt(3);
				String fechaInicio = rs.getString(4);
				String fechaFin = rs.getString(5);

				Grupo g = new Grupo(idGrupo, idMateria, idDocente, fechaInicio, fechaFin);
				grupos.add(g);
			}
		} catch (Exception e) {
		}
		return grupos;
	}

	public ArrayList<Persona> getPersona() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "    FROM persona p\r\n" + "   ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idPersona = rs.getInt(1);
				String nombre = rs.getString(2);
				String email = rs.getString(3);
				String direccion = rs.getString(4);

				Persona p = new Persona(idPersona, nombre, email, direccion);
				personas.add(p);
			}
		} catch (Exception e) {
		}
		return personas;
	}
	
	public ArrayList<Pagos> getPagos(){
		ArrayList<Pagos> pagos = new ArrayList<Pagos>();
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT p.IDpago,p.Creditos,p.Costo,e.IDestudiante\r\n" + 
					"    FROM estudiante e INNER JOIN pagos p\r\n" + 
					"  ON e.IDestudiante = p.IDestudiante\r\n" + 
					"   ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idPago = rs.getInt(1);
				int creditos = rs.getInt(2);
				double costo = rs.getDouble(3);
				int idEstudiante = rs.getInt(4);

				Pagos p = new Pagos(idPago, creditos, costo, idEstudiante);
				pagos.add(p);
			}
		} catch (Exception e) {
		}
		return pagos;
	}
	
	public ArrayList<Clase> getClase() {
		ArrayList<Clase> clases = new ArrayList<Clase>();
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT c.IDgrupo,c.IDestudiante,c.Nota\r\n" + 
					"    FROM clase c INNER JOIN grupo g\r\n" + 
					"  ON g.IDgrupo = c.IDgrupo INNER JOIN estudiante e\r\n" + 
					"  ON c.IDestudiante = e.IDestudiante";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idGrupo = rs.getInt(1);
				int idEstudiante = rs.getInt(2);
				int nota = rs.getInt(3);

				Clase c = new Clase(idGrupo, idEstudiante, nota);
				clases.add(c);
			}
		} catch (Exception e) {
		}
		return clases;
	}
	public Docente getUserPassword(String user, String password) {
		Docente res = new Docente(0, "", "", "", 0, "", "");
		try {
			Connection con = Conexion.getInstance().getConnection();
			String sql = "SELECT d.IdDocente, d.IdPersona, p.nombre, p.email, p.direccion\r\n" + 
					"FROM docente d, persona p\r\n" + 
					"WHERE d.Username='"+user+"' AND d.Password='"+password+"' AND p.IdPersona=d.IdPersona ";
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int idPersona=rs.getInt(1);
				int idDocente = rs.getInt(2);
				String nombre = rs.getString(3);
				String email = rs.getString(4);
				String direccion = rs.getString(5);

				Docente doc= new Docente(idPersona, nombre, email, direccion, idDocente, user, password);
				res=doc;
				
			}
			
		}catch(Exception e) {
			
		}return res;
	}
	public Estudiante getEstudiante(int idEstudiante) {
		Estudiante res= new Estudiante(0,"", "","", 0);
		try {
			Connection con= Conexion.getInstance().getConnection();
			String sql = "SELECT *\r\n" + 
					"FROM estudiante e, persona p\r\n" + 
					"WHERE e.IdPersona=p.IdPersona AND e.IdEstudiante = "+idEstudiante;
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				int idPersona = rs.getInt(2);
				String nombre = rs.getString(4);
				String email = rs.getString(5);
				String direccion = rs.getString(6);
				Estudiante e = new Estudiante(idPersona, nombre, email, direccion, idEstudiante);
				res = e;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public String[] getBalance(int idEstudiante) {
		String sql = "SELECT  persona.nombre, SUM(creditos)-SUM(gasto)\r\n" + 
				"FROM pagos, estudiante, persona,gastoscreditosestudiante\r\n" + 
				"WHERE pagos.IdEstudiante=estudiante.IdEstudiante AND estudiante.IdPersona = persona.IdPersona AND estudiante.IdEstudiante = gastoscreditosestudiante.idEstudiante AND estudiante.IdEstudiante=1\r\n" + 
				"GROUP BY estudiante.IdEstudiante";
		String[] res = new String[2];
		try {
			Connection con= Conexion.getInstance().getConnection();
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				String nombre = rs.getString(1);
				String balance = rs.getString(2);
				res[0] = nombre;
				res[1] = balance;
				
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
}
