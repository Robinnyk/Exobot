package trBusinessLogic;

import java.util.List;

import trDataAccess.Interfaces.trIDAO;
import trInfrastructure.AppException;

public class FactoryBL<T>  {
    private final trIDAO<T> oDAO;

    public FactoryBL(Class<? extends trIDAO<T>> classDAO) {
        try {
            this.oDAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            AppException er = new AppException("Error al instanciar classDAO<T>", e, getClass(), "FactoryBL(...)");
            throw new RuntimeException(er);
        }
    }
 
    public List<T> getAll() throws AppException {
         return oDAO.readAll();
    }

    public T getBy(Integer id) throws AppException {
        return oDAO.readBy(id);
    }

    public boolean add(T oT) throws AppException {
        return oDAO.create(oT);
    }

    public boolean upd(T oT) throws AppException {
        return oDAO.update(oT);
    }

    public boolean del(Integer id) throws AppException {
        return oDAO.delete(id);
    }

    public Integer getMinReg(String tableCelName) throws AppException {
        return oDAO.getMinReg(tableCelName);
    }

    public Integer getMaxReg(String tableCelName) throws AppException {
        return oDAO.getMaxReg(tableCelName);
    }

    // Constructor que usa un Supplier para crear la instancia de T
    // public FactoryBL(Supplier<IDAO<T>> supplier) {
    //     this.oDAO = supplier.get(); 
    // }

}
