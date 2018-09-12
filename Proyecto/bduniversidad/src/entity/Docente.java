/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


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
    

    public int getIdDocente() {
        return idDocente;
    }

    
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

   
    public String getUsername() {
        return username;
    }

   
    public void setUsername(String username) {
        this.username = username;
    }

   
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
