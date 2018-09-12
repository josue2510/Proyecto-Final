package entity;

public class Pagos{
    
    private int idPago;
    private int creditos;
    private double costo;
    private int idEstudiante;
    
    public Pagos(int idPago, int creditos, double costo, int idEstudiante)
    {
        this.idEstudiante=idEstudiante;
        this.idPago=idPago;
        this.costo=costo;
        this.creditos=creditos;
    }

   
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    
    public int getCreditos() {
        return creditos;
    }

    
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    
    public double getCosto() {
        return costo;
    }

    
    public void setCosto(double costo) {
        this.costo = costo;
    }

   
    public int getIdEstudiante() {
        return idEstudiante;
    }

   
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
}
