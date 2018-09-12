
package entity;


public class Estudiante extends Persona {
    private int idEstudiante;
    private int idPersona;
    
    public Estudiante(int idPersona, String nombre, String email, String direcccion, int idEstudiante)
    {
        super(idPersona, nombre, email, direcccion);
        this.idPersona =idPersona;
        this.idEstudiante=idEstudiante;
    }

    
    public int getIdEstudiante() {
        return idEstudiante;
    }

    
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    
    public int getIdPersona() {
        return idPersona;
    }

    
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
}
