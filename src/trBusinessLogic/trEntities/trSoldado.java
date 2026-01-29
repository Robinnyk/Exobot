package trBusinessLogic.trEntities;

public class trSoldado {

    protected String trNombre;
    protected String trCedula;

    public String getTrNombre() {
        return trNombre;
    }

    public void setTrNombre(String trNombre) {
        this.trNombre = trNombre;
    }

    public String getTrCedula() {
        return trCedula;
    }

    public void setTrCedula(String trCedula) {
        this.trCedula = trCedula;
    }

    public trSoldado() {}

    public trSoldado(String nombre, String cedula) {
        trNombre = nombre;
        trCedula = cedula;
    }

    
    @Override
    public String toString() {
        return getClass().getSimpleName()
            + "\n trNombre: " + trNombre
            + "\n trCedula: " + trCedula;
    }
    
}
