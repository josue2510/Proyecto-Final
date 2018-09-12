package entity;


public class Materia {
  

	private int idMateria;
    private String nombre;
    private int costoCreditos;
    private int duracion_dias;
    
    public Materia(int idMateria, String nombre, int costoCreditos, int duracion_dias)
    {
        this.costoCreditos=costoCreditos;
        this.nombre=nombre;
        this.idMateria=idMateria;
        this.duracion_dias=duracion_dias;
    }

    
    public int getIdMateria() {
        return idMateria;
    }

   
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

   
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public int getCostoCreditos() {
        return costoCreditos;
    }

   
    public void setCostoCreditos(int costoCreditos) {
        this.costoCreditos = costoCreditos;
    }

       public int getDuracion_dias() {
        return duracion_dias;
    }

    
    public void setDuracion_dias(int duracion_dias) {
        this.duracion_dias = duracion_dias;
    }
    
    @Override
  	public String toString() {
  		return "Materia [idMateria=" + idMateria + ", nombre=" + nombre + ", costoCreditos=" + costoCreditos
  				+ ", duracion_dias=" + duracion_dias + "]";
  	}

    
}
