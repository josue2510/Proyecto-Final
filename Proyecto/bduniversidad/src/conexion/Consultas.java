
package conexion;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

import entity.Estudiante;
import entity.Materia;
public class Consultas {
    conexion con;
    
    public Consultas()
    {}
    public ArrayList<Materia> getMateria(){
    	ArrayList<Materia> materias = new ArrayList<Materia>();
    	try {

    	Connection con = conexion.getInstance().getConnection();
    	String sql = "SELECT * FROM materia ";
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(sql);
    	while(rs.next())
    	{
    		int idMateria = rs.getInt(1);
    		String nombre = rs.getString(2);
    		int costo = rs.getInt(3);
    		int duracionDias = rs.getInt(4);
    		Materia m = new Materia(idMateria, nombre, costo, duracionDias);
    		materias.add(m);
    	}
    	}
    	catch(Exception e){}
    	
    	return materias;
    }
    
    public ArrayList<Estudiante> getEstudiantes(){
    	ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    	try {
    	Connection con = conexion.getInstance().getConnection();
    	String sql = "SELECT IDestudiante,estudiante.IDpersona,nombre,email,direccion\r\n" + 
    			"    FROM estudiante,persona\r\n" + 
    			"    WHERE persona.IDpersona = estudiante.IDpersona";
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
    	}
    	catch(Exception e) {}
    	return estudiantes;
    }
}
