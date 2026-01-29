package trDataAccess.trDTO;

public class trCatalogoDTO {
    
    private Integer trIdCatalogo;
    private Integer trIdCatalogoTipo;
    private String  trNombre;
    private String  trDescripcion;
    private String  trEstado;
    private String  trFechaCreacion;
    private String  trFechaModifica;

    public Integer getTrIdCatalogo() {
        return trIdCatalogo;
    }

    public void setTrIdCatalogo(Integer trIdCatalogo) {
        this.trIdCatalogo = trIdCatalogo;
    }

    public Integer getTrIdCatalogoTipo() {
        return trIdCatalogoTipo;
    }

    public void setTrIdCatalogoTipo(Integer trIdCatalogoTipo) {
        this.trIdCatalogoTipo = trIdCatalogoTipo;
    }

    public String getTrNombre() {
        return trNombre;
    }

    public void setTrNombre(String trNombre) {
        this.trNombre = trNombre;
    }

    public String getTrDescripcion() {
        return trDescripcion;
    }

    public void setTrDescripcion(String trDescripcion) {
        this.trDescripcion = trDescripcion;
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

    public trCatalogoDTO() {}

    public trCatalogoDTO(Integer idmjCatalogoTipo, String nombre, String descripcion) {
        trIdCatalogo   = 0;
        trIdCatalogoTipo = idmjCatalogoTipo;
        trNombre       = nombre;
        trDescripcion  = descripcion;
    }

    public trCatalogoDTO(Integer idmjCatalogo, Integer idmjCatalogoTipo, String nombre, String descripcion,
            String estado, String fechaCreacion, String fechaModifica) {
        trIdCatalogo     = idmjCatalogo;
        trIdCatalogoTipo = idmjCatalogoTipo;
        trNombre         = nombre;
        trDescripcion    = descripcion;
        trEstado         = estado;
        trFechaCreacion  = fechaCreacion;
        trFechaModifica  = fechaModifica;
    }


    @Override
    public String toString() {
        return getClass().getName()
            + "\n trIdCatalogo     : " + getTrIdCatalogo()
            + "\n trIdCatalogoTipo : " + getTrIdCatalogoTipo()
            + "\n trNombre         : " + getTrNombre()
            + "\n trDescripcion    : " + getTrDescripcion()
            + "\n trEstado         : " + getTrEstado()
            + "\n trFechaCreacion  : " + getTrFechaCreacion()
            + "\n trFechaModifica  : " + getTrFechaModifica()
            + "\n --------------------------- ";
    }
}
