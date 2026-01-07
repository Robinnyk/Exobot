package trDataAcces;

import java.util.List;

public interface trIDAO <T> {  // obligatorio implementar los metodos CRUD en los DAO

    public boolean create(T entity)    throws Exception;
    public List<T> readAll()           throws Exception;   // Busqueda general (lee todos los registros)
    public boolean update(T entity)    throws Exception;
    public boolean delete(Integer id)  throws Exception;
    
    public T       readBy(Integer id)  throws Exception;   // Busqueda en especifico por ID
    public Integer getMaxReg()         throws Exception;   // Obtener el maximo registro insertado

    // T es un dato generico que se define en la implementacion del DAO (asi evitamos hacer un CRUD por cada entidad/clase)

}


