package trDataAccess.trDTO;

public class trPersonaTipoDTO {
    private Integer trIdPersona;
    private Integer trIdCatalogo;
    private Integer trIdCatalogoTipo;
    private String trNombre;
    private String trDescripcion;
    private String trEstado;
    private String trFechaCreacion;
    private String trFechaModifica;

    public trPersonaTipoDTO(){}

    public trPersonaTipoDTO(Integer idmjCatalogo, Integer tridCatalogoTipo,Integer idmjPersona, String nombre, String descripcion, String estado,
            String fechaCreacion, String fechaModifica) {
        trIdPersona = idmjPersona;
        trIdCatalogo = idmjCatalogo;
        trIdCatalogoTipo = tridCatalogoTipo;
        trNombre = nombre;
        trDescripcion = descripcion;
        trEstado = estado;
        trFechaCreacion = fechaCreacion;
        trFechaModifica = fechaModifica;
    }
   
    public Integer getTrIdPersona() {
        return trIdPersona;
    }

    public void setTrIdPersona(Integer trIdPersona) {
        this.trIdPersona = trIdPersona;
    }

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
   

    @Override
    public String toString(){
        return "\n" + getClass().getName()
            + "\n trIdPersona   " + getTrIdPersona()
            + "\n trIdCatalogo   " + getTrIdCatalogo()
            + "\n trIdCatalogoTipo:   " + getTrIdCatalogo()
            + "\n trNombre   " + getTrNombre()
            + "\n trdescripcion:   " + getTrDescripcion()
            + "\n trestado:   " + getTrEstado()
            + "\n trFechaCreacion:   " + getTrFechaCreacion()
            + "\n trFechaModifica:   " + getTrFechaModifica();

    }


}
