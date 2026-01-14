package trBusinessLogic.trEntities;

import java.util.List;

import trDataAccess.trPersonaTipoDAO;
import trDataAccess.trDTO.trPersonaTipoDTO;

public class trPersonaTipoBL {

    private trPersonaTipoDTO personaTipo;
    private trPersonaTipoDAO pTipoDAO = new trPersonaTipoDAO();

    public trPersonaTipoBL() {}

    public List<trPersonaTipoDTO> getAllPersonaTipo() throws Exception {
        // Regla de negocio: Convertir el nombre del tipo de persona a mayúsculas

        List<trPersonaTipoDTO> lst = pTipoDAO.readAll();
        for (trPersonaTipoDTO pTipoDTO : lst) {
            pTipoDTO.setTrNombre(pTipoDTO.getTrNombre().toUpperCase());
        }
        return lst;
    }

    public trPersonaTipoDTO getPersonaTipoById(Integer id) throws Exception {
        personaTipo = pTipoDAO.readBy(id);
        return personaTipo;
    }

    public boolean create(trPersonaTipoDTO trPersonaTipoDTO) throws Exception {
        return pTipoDAO.create(trPersonaTipoDTO);       
    }

    public boolean update(trPersonaTipoDTO trPersonaTipoDTO) throws Exception {
        return pTipoDAO.update(trPersonaTipoDTO);
       
    }

    public boolean delete(trPersonaTipoDTO trPersonaTipoDTO) throws Exception {
        return pTipoDAO.delete(trPersonaTipoDTO.getTrIdCatalogo());
       
    }

    public Integer getMaxRow() throws Exception {
        return pTipoDAO.getRowCout();
    }
}
