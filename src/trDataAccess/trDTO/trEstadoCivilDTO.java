package trDataAccess.trDTO;

public class trEstadoCivilDTO {

     private Integer trIdCatalogo;
    private Integer trIdCatalogoTipo;
    private String  trNombre;
    private String  trDescripcion;
    private String  trEstado;
    private String  trFechaCreacion;
    private String  trFechaModificacion;

    public trEstadoCivilDTO() {}
   
    public trEstadoCivilDTO(Integer trIdCatalogo, Integer trIdCatalogoTipo, String trNombre, String trDescripcion,
            String trEstado, String trFechaCreacion, String trFechaModificacion) {
        this.trIdCatalogo = trIdCatalogo;
        this.trIdCatalogoTipo = trIdCatalogoTipo;
        this.trNombre = trNombre;
        this.trDescripcion = trDescripcion;
        this.trEstado = trEstado;
        this.trFechaCreacion = trFechaCreacion;
        this.trFechaModificacion = trFechaModificacion;
    }

    public Integer getTrIdCatalogoTipo() {
        return trIdCatalogoTipo;
    }

    public void setTrIdCatalogoTipo(Integer trIdCatalogoTipo) {
        this.trIdCatalogoTipo = trIdCatalogoTipo;
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

    public String getTrFechaModificacion() {
        return trFechaModificacion;
    }

    public void setTrFechaModificacion(String trFechaModificacion) {
        this.trFechaModificacion = trFechaModificacion;
    }

    public Integer getTrIdCatalogo() {
        return trIdCatalogo;
    }

    public void setTrIdCatalogo(Integer trIdCatalogo) {
        this.trIdCatalogo = trIdCatalogo;
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

    @Override
    public String toString() {
        return  "\n" + getClass().getName() + 
                "\n IdCatalogo:             " + getTrIdCatalogo() +
                "\n IdCatalogoTipo:         " + getTrIdCatalogoTipo() +
                "\n Nombre:                 " + getTrNombre() +
                "\n Descripcion:            " + getTrDescripcion() +
                "\n Estado:                 " + getTrEstado() +
                "\n FechaCreacion:          " + getTrFechaCreacion() +
                "\n FechaModificacion:'" + getTrFechaModificacion();
    }

}
