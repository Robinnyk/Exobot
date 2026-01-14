package trDataAccess.trDTO;

public class trSexoAnteDTO {

    private Integer     trIdSexo; 
    private String      trNombre;
    private String      trEstado;
    private String      trFechaCreacion;
    private String      trFechaModificacion;

    public trSexoAnteDTO() {}     // Constructor por defecto

    public trSexoAnteDTO(String trNombre) {
        this.trNombre = trNombre;
    }

    public trSexoAnteDTO(Integer trIdSexo, String trNombre, String trEstado, String trFechaCreacion,String trFechaModificacion) {
        this.trIdSexo = trIdSexo;
        this.trNombre = trNombre;
        this.trEstado = trEstado;
        this.trFechaCreacion = trFechaCreacion;
        this.trFechaModificacion = trFechaModificacion;
    }


    public Integer gettrIdSexo() {
        return trIdSexo;
    }

    public void settrIdSexo(Integer trIdSexo) {
        this.trIdSexo = trIdSexo;
    }

    public String gettrNombre() {
        return trNombre;
    }

    public void settrNombre(String trNombre) {
        this.trNombre = trNombre;
    }

    public String gettrEstado() {
        return trEstado;
    }

    public void settrEstado(String trEstado) {
        this.trEstado = trEstado;
    }

    public String gettrFechaCreacion() {
        return trFechaCreacion;
    }

    public void settrFechaCreacion(String trFechaCreacion) {
        this.trFechaCreacion = trFechaCreacion;
    }

    public String gettrFechaModificacion() {
        return trFechaModificacion;
    }

    public void settrFechaModificacion(String trFechaModificacion) {
        this.trFechaModificacion = trFechaModificacion;
    }

    @Override
    public String toString() {
        return getClass().getName() + 
                "\n IdSexo:" + gettrIdSexo() +
                "\n Nombre:'" + gettrNombre() +
                "\n Estado:'" + gettrEstado() +
                "\n FechaCreacion:'" + gettrFechaCreacion() +
                "\n FechaModificacion:'" + gettrFechaModificacion();
    }

}