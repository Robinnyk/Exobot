package trDataAccess.trDTO;

public class trExoBotDTO {

    private Integer trIdExoBot;
    private Integer trIdIABot;
    private String  trNombre;
    private String  trSerie;
    private String  trEntreno;
    private Integer trInmovil;
    private String  trEstado;
    private String  trFechaCreacion;
    private String  trFechaModifica;

    public Integer getTrIdExoBot() {
        return trIdExoBot;
    }

    public void setTrIdExoBot(Integer trIdExoBot) {
        this.trIdExoBot = trIdExoBot;
    }


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

    public String getTrSerie() {
        return trSerie;
    }

    public void setTrSerie(String trSerie) {
        this.trSerie = trSerie;
    }

    public String getTrEntreno() {
        return trEntreno;
    }

    public void setTrEntreno(String trEntreno) {
        this.trEntreno = trEntreno;
    }

    public Integer getTrInmovil() {
        return trInmovil;
    }

    public void setTrInmovil(Integer trInmovil) {
        this.trInmovil = trInmovil;
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

    public trExoBotDTO() {}

    /** Para ExoTrooper: trNombre = TipoExobot (ExoMedico, ExoAsalto, ...) */
    public trExoBotDTO(Integer tridIABot, String tipoExobot, String serie) {
        trIdExoBot = 0;
        trIdIABot  = tridIABot;
        trNombre   = tipoExobot;
        trSerie    = serie;
        trEntreno  = "NO";
        trInmovil = 0;
    }

    public trExoBotDTO(Integer idTrExoBot, Integer tridIABot, String nombre, String serie, String entreno, Integer noAccion, String estado, String fechaCreacion, String fechaModifica) {
        trIdExoBot = idTrExoBot;
        trIdIABot  = tridIABot;
        trNombre   = nombre;
        trSerie    = serie;
        trEntreno  = entreno;
        trInmovil = noAccion != null ? noAccion : 0;
        trEstado   = estado;
        trFechaCreacion = fechaCreacion;
        trFechaModifica = fechaModifica;
    }

    

    @Override
    public String toString() {
        return getClass().getName()
            + "\n trIdExaBot : " + getTrIdExoBot()
            + "\n trIdIABot  : " + getTrIdIABot()
            + "\n trNombre   : " + getTrNombre()
            + "\n trSerie    : " + getTrSerie()
            + "\n trEntreno  : " + getTrEntreno()
            + "\n trInmovil : " + getTrInmovil()
            + "\n trEstado   : " + getTrEstado()
            + "\n trFechaCreacion : " + getTrFechaCreacion()
            + "\n trFechaModifica : " + getTrFechaModifica()
            + "\n --------------------------- ";
    }
}
