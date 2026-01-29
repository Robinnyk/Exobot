package trDataAccess.trDTO;

public class trEnsambladoDTO {
    
    private Integer trIdEnsamblado;
    private Integer trIdIABot;
    private Integer trIdExaBot;
    private Integer trIdPersonaSoldado;
    private Integer trIdPersonaMecatronico;
    private String  trEstado;
    private String  trFechaCreacion;
    private String  trFechaModifica;

    public Integer getTrIdEnsamblado() {
        return trIdEnsamblado;
    }

    public void setTrIdEnsamblado(Integer trIdEnsamblado) {
        this.trIdEnsamblado = trIdEnsamblado;
    }

    public Integer getTrIdIABot() {
        return trIdIABot;
    }

    public void setTrIdIABot(Integer trIdIABot) {
        this.trIdIABot = trIdIABot;
    }

    public Integer getTrIdExaBot() {
        return trIdExaBot;
    }

    public void setTrIdExaBot(Integer trIdExaBot) {
        this.trIdExaBot = trIdExaBot;
    }

    public Integer getTrIdPersonaSoldado() {
        return trIdPersonaSoldado;
    }

    public void setTrIdPersonaSoldado(Integer trIdPersonaSoldado) {
        this.trIdPersonaSoldado = trIdPersonaSoldado;
    }

    public Integer getTrIdPersonaMecatronico() {
        return trIdPersonaMecatronico;
    }

    public void setTrIdPersonaMecatronico(Integer trIdPersonaMecatronico) {
        this.trIdPersonaMecatronico = trIdPersonaMecatronico;
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

    public trEnsambladoDTO() {}

    public trEnsambladoDTO(Integer idIABot, Integer idExaBot, Integer idPersonaSoldado, Integer idPersonaMecatronico) {
        trIdEnsamblado       = 0;
        trIdIABot            = idIABot;
        trIdExaBot           = idExaBot;
        trIdPersonaSoldado   = idPersonaSoldado;
        trIdPersonaMecatronico = idPersonaMecatronico;
    }

    public trEnsambladoDTO(Integer idmjEnsamblado, Integer idmjIABot, Integer idmjExaBot, Integer idmjPersonaSoldado,
            Integer tridPersonaMecatronico, String estado, String fechaCreacion, String fechaModifica) {
        trIdEnsamblado         = idmjEnsamblado;
        trIdIABot              = idmjIABot;
        trIdExaBot             = idmjExaBot;
        trIdPersonaSoldado     = idmjPersonaSoldado;
        trIdPersonaMecatronico = tridPersonaMecatronico;
        trEstado               = estado;
        trFechaCreacion        = fechaCreacion;
        trFechaModifica        = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
            + "\n trIdEnsamblado         : " + getTrIdEnsamblado()
            + "\n trIdIABot              : " + getTrIdIABot()
            + "\n trIdExaBot             : " + getTrIdExaBot()
            + "\n trIdPersonaSoldado     : " + getTrIdPersonaSoldado()
            + "\n trIdPersonaMecatronico : " + getTrIdPersonaMecatronico()
            + "\n trEstado               : " + getTrEstado()
            + "\n trFechaCreacion        : " + getTrFechaCreacion()
            + "\n trFechaModifica        : " + getTrFechaModifica()
            + "\n --------------------------- ";
    }
}
