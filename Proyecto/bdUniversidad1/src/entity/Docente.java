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
public class Docente extends Persona {
    
    private int idDocente;
    private String username;
    private String password;
    
    public Docente(int idPersona, String nombre, String email, String direccion, int idDocente, String username, String password) {
        super(idPersona, nombre, email, direccion);
        this.idDocente = idDocente;
        this.username = username;
        this.password=password;
    }
    


    /**
     * @return the idDocente
     */
    public int getIdDocente() {
        return idDocente;
    }

    /**
     * @param idDocente the idDocente to set
     */
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
