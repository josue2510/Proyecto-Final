/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lopez
 */
public class Estudiante extends Persona {
    private int idEstudiante;
    private int idPersona;
    
    public Estudiante(int idPersona, String nombre, String email, String direcccion, int idEstudiante)
    {
        super(idPersona, nombre, email, direcccion);
        this.idPersona =idPersona;
        this.idEstudiante=idEstudiante;
    }

    /**
     * @return the idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
}
