package entity;
public class Clase {
    private int idGrupo;
    private int idEstudiante;
    private int nota;
    public Clase (int idGrupo, int idEstudiante, int nota)
    {
        this.idEstudiante= idEstudiante;
        this.idGrupo=idGrupo;
        this.nota=nota;
    }

   
    public int getIdGrupo() {
        return idGrupo;
    }

   
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

   
    public int getIdEstudiante() {
        return idEstudiante;
    }

   
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

   
    public int getNota() {
        return nota;
    }

   
    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
