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

    /**
     * @return the idMateria
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * @param idMateria the idMateria to set
     */
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the costoCreditos
     */
    public int getCostoCreditos() {
        return costoCreditos;
    }

    /**
     * @param costoCreditos the costoCreditos to set
     */
    public void setCostoCreditos(int costoCreditos) {
        this.costoCreditos = costoCreditos;
    }

    /**
     * @return the duracion_dias
     */
    public int getDuracion_dias() {
        return duracion_dias;
    }

    /**
     * @param duracion_dias the duracion_dias to set
     */
    public void setDuracion_dias(int duracion_dias) {
        this.duracion_dias = duracion_dias;
    }
    
}
