package entity;


public class Grupo {
    private int idGrupo;
    private int idMateria;
    private int idDocente;
    private String fechaInicio;
    private String fechaFin;   
    public Grupo(int idGrupo, int idMateria, int idDocente, String fechaInicio, String fechaFin)
    {
        this.idDocente=idDocente;
        this.idGrupo=idGrupo;
        this.idMateria=idMateria;
        this.fechaFin=fechaFin;
        this.fechaInicio=fechaInicio;
    }

    
    public int getIdGrupo() {
        return idGrupo;
    }

    
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

        public int getIdMateria() {
        return idMateria;
    }

    
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    
    public int getIdDocente() {
        return idDocente;
    }

    
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    
    public String getFechaInicio() {
        return fechaInicio;
    }

    
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    
    public String getFechaFin() {
        return fechaFin;
    }

   
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
