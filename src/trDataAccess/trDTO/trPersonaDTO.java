package trDataAccess.trDTO;

public class trPersonaDTO {

    private Integer trIdPersona;
    private Integer trIdCatalogoTipoPersona;
    private Integer trIdCatalogoSexo;
    private Integer trIdCatalogoEstadoCivil;
    private String  trCedula;
    private String  trNombre;
    private String  trApellido;
    private String  trEstado;
    private String  trFechaCreacion;
    private String  trFechaModifica;

 
    public trPersonaDTO() {}

    public trPersonaDTO(Integer idCatalogoTipoPersona, Integer tridCatalogoSexo, Integer tridCatalogoEstadoCivil,
            String cedula, String nombre, String apellido) {
        trIdPersona              = 0;
        trIdCatalogoTipoPersona  = idCatalogoTipoPersona;
        trIdCatalogoSexo         = tridCatalogoSexo;
        trIdCatalogoEstadoCivil  = tridCatalogoEstadoCivil;
        trCedula                 = cedula;
        trNombre                 = nombre;
        trApellido               = apellido;
    }

    public trPersonaDTO(Integer idmjPersona, Integer idCatalogoTipoPersona, Integer tridCatalogoSexo,
            Integer tridCatalogoEstadoCivil, String cedula, String nombre, String apellido, String estado, String fechaCreacion, String fechaModifica) {
        trIdPersona              = idmjPersona;
        trIdCatalogoTipoPersona  = idCatalogoTipoPersona;
        trIdCatalogoSexo         = tridCatalogoSexo;
        trIdCatalogoEstadoCivil  = tridCatalogoEstadoCivil;
        trCedula                 = cedula;
        trNombre                 = nombre;
        trApellido               = apellido;
        trEstado                 = estado;
        trFechaCreacion          = fechaCreacion;
        trFechaModifica          = fechaModifica;
    }

       public Integer getTrIdPersona() {
        return trIdPersona;
    }

    public void setTrIdPersona(Integer trIdPersona) {
        this.trIdPersona = trIdPersona;
    }

    public Integer getTrIdCatalogoTipoPersona() {
        return trIdCatalogoTipoPersona;
    }

    public void setTrIdCatalogoTipoPersona(Integer trIdCatalogoTipoPersona) {
        this.trIdCatalogoTipoPersona = trIdCatalogoTipoPersona;
    }

    public Integer getTrIdCatalogoSexo() {
        return trIdCatalogoSexo;
    }

    public void setTrIdCatalogoSexo(Integer trIdCatalogoSexo) {
        this.trIdCatalogoSexo = trIdCatalogoSexo;
    }

    public Integer getTrIdCatalogoEstadoCivil() {
        return trIdCatalogoEstadoCivil;
    }

    public void setTrIdCatalogoEstadoCivil(Integer trIdCatalogoEstadoCivil) {
        this.trIdCatalogoEstadoCivil = trIdCatalogoEstadoCivil;
    }

    public String getTrCedula() {
        return trCedula;
    }

    public void setTrCedula(String trCedula) {
        this.trCedula = trCedula;
    }

    public String getTrNombre() {
        return trNombre;
    }

    public void setTrNombre(String trNombre) {
        this.trNombre = trNombre;
    }

    public String getTrApellido() {
        return trApellido;
    }

    public void setTrApellido(String trApellido) {
        this.trApellido = trApellido;
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

    @Override
    public String toString() {
        return getClass().getName()
            + "\n trIdPersona             : " + getTrIdPersona()
            + "\n trIdCatalogoTipoPersona : " + getTrIdCatalogoTipoPersona()
            + "\n trIdCatalogoSexo        : " + getTrIdCatalogoSexo()
            + "\n trIdCatalogoEstadoCivil : " + getTrIdCatalogoEstadoCivil()
            + "\n trCedula                : " + getTrCedula()
            + "\n trNombre                : " + getTrNombre()
            + "\n trApellido              : " + getTrApellido()
            + "\n trEstado                : " + getTrEstado()
            + "\n trFechaCreacion         : " + getTrFechaCreacion()
            + "\n trFechaModifica         : " + getTrFechaModifica()
            + "\n --------------------------- ";
    }
}
