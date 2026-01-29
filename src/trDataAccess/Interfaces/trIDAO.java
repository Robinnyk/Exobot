package trDataAccess.Interfaces;

import java.util.List;

import trInfrastructure.AppException;

public interface trIDAO <T> {  // obligatorio implementar los metodos CRUD en los DAO

    public List<T> readAll()            throws AppException;
    public T       readBy (Integer id)  throws AppException;
    public boolean create (T entity)    throws AppException;
    public boolean update (T entity)    throws AppException;
    public boolean delete (Integer id)  throws AppException;
    public Integer getCountReg()        throws AppException;
    public Integer getMinReg(String tableCelName) throws AppException;
    public Integer getMaxReg(String tableCelName) throws AppException;
    
      // Busqueda en especifico por ID
    // public Integer getMaxReg()         throws Exception;   // Obtener el maximo registro insertado

    // T es un dato generico que se define en la implementacion del DAO (asi evitamos hacer un CRUD por cada entidad/clase)

}


