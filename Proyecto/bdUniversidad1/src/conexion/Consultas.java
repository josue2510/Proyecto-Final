package conexion;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

import entity.Estudiante;
import entity.Materia;
import entity.Pagos;

public class Consultas {
	conexion con;

	public Consultas() {
	}

	public ArrayList<Materia> getMateria() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		try {

			Connection con = conexion.getInstance().getConnection();
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
			Connection con = conexion.getInstance().getConnection();
			String sql = " Select IdEstudiante , estudiante.IdPersona , nombre ,email,direccion\r\n"
					+ "from estudiante , persona\r\n" + "where persona.IdPersona= estudiante.IdPersona";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int idEstudiante = rs.getInt(1);
				int idPersona = rs.getInt(2);
				String nombre = rs.getString(3);
				String email = rs.getString(4);
				String direcccion = rs.getString(5);
				Estudiante Est = new Estudiante(idPersona, nombre, email, direcccion, idEstudiante);
				estudiantes.add(Est);

			}

		} catch (Exception e) {
		}

		return estudiantes;

	}
	public ArrayList<Pagos> getPagos(){
		ArrayList<Pagos> pagados = new ArrayList<Pagos>();
		
		try {
			Connection con = conexion.getInstance().getConnection();
			String sql = "select pagos.IdPago, pagos.IdEstudiante , pagos.creditos, pagos.costo\r\n" + 
					"from estudiante, pagos\r\n" + 
					"where estudiante.IdEstudiante=pagos.IdEstudiante";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next()) {
				int idPago = rs.getInt(1);
				int idEstudiante = rs.getInt(2);
				int creditos = rs.getInt(3);
				double costo = rs.getDouble(4);
				Pagos pag= new Pagos(idPago, creditos, costo, idEstudiante);
				pagados.add(pag);
			}
		}catch(Exception e) {
			
		}
		return pagados;
	}
}