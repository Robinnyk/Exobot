package trDataAccess.trDTO;

public class trIABotDTO {

    private Integer trIdIABot;
    private String  trNombre;
    private String  trObservacion;
    private String  trEstado;
    private String  trFechaCreacion;
    private String  trFechaModifica;

    public Integer getTrIdIABot() {
        return trIdIABot;
    }

    public void setTrIdIABot(Integer trIdIABot) {
        this.trIdIABot = trIdIABot;
    }

    public String getTrNombre() {
        return trNombre;
    }

    public void setTrNombre(String trNombre) {
        this.trNombre = trNombre;
    }

    public String getTrObservacion() {
        return trObservacion;
    }

    public void setTrObservacion(String trObservacion) {
        this.trObservacion = trObservacion;
    }

    public String getTrEstado() {
        return trEstado;
    }

    public void setTrEstado(String trEstado) {
        this.trEstado = trEstado;
    }

    public String getTrFechaCreacion() {
        return trFechaCreacion;
    }

    public void setTrFechaCreacion(String trFechaCreacion) {
        this.trFechaCreacion = trFechaCreacion;
    }

    public String getTrFechaModifica() {
        return trFechaModifica;
    }

    public void setTrFechaModifica(String trFechaModifica) {
        this.trFechaModifica = trFechaModifica;
    }

    public trIABotDTO() {}

    public trIABotDTO(String nombre, String observacion) {
        trIdIABot   = 0;
        trNombre    = nombre;
        trObservacion = observacion;
    }

    public trIABotDTO(Integer idmjIABot, String nombre, String observacion, String fechaCreacion, String estado, String fechaModifica   ) {
        trIdIABot     = idmjIABot;
        trNombre      = nombre;
        trObservacion = observacion;
        trFechaCreacion   = fechaCreacion;
        trEstado          = estado;
        trFechaModifica   = fechaModifica;
    }

    

    @Override
    public String toString() {
        return getClass().getName()
            + "\n trIdIABot    : " + getTrIdIABot()
            + "\n trNombre     : " + getTrNombre()
            + "\n trObservacion: " + getTrObservacion()
            + "\n trEstado     : " + getTrEstado()
            + "\n trFechaCreacion  : " + getTrFechaCreacion()
            + "\n trFechaModifica : " + getTrFechaModifica()
            + "\n --------------------------- ";
    }
}
