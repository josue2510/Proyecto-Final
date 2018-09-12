
package entity;

public class Persona {
    private int idPersona;
    private String nombre;
    private String email;
    private String direccion;
    public Persona(int idPersona, String nombre, String email, String direccion)
    {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

 
    public int getIdPersona() {
        return idPersona;
    }

    
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
           
    
}
