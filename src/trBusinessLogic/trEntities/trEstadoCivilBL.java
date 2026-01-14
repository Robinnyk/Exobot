package trBusinessLogic.trEntities;

import java.util.List;

import trDataAccess.trEstadoCivilDAO;
import trDataAccess.trDTO.trEstadoCivilDTO;

public class trEstadoCivilBL {

    private trEstadoCivilDTO estadoCivil;
    private trEstadoCivilDAO ecDAO = new trEstadoCivilDAO();

    public trEstadoCivilBL() {}

    public List<trEstadoCivilDTO> getAllEstadoCivil() throws Exception {

        // Regla de negocio: Convertir el nombre del estado civil a mayúsculas
        
        List<trEstadoCivilDTO> lst = ecDAO.readAll();
        for (trEstadoCivilDTO eCivilDTO : lst) {
            eCivilDTO.setTrNombre(eCivilDTO.getTrNombre().toUpperCase());
        }
        return lst;
    }

    public trEstadoCivilDTO getEstadoCivilById(Integer id) throws Exception {
        estadoCivil = ecDAO.readBy(id);
        return estadoCivil;
    }

    public boolean create(trEstadoCivilDTO trEstadoCivilDTO) throws Exception {
        return ecDAO.create(trEstadoCivilDTO);       
    }

    public boolean update(trEstadoCivilDTO trEstadoCivilDTO) throws Exception {
        return ecDAO.update(trEstadoCivilDTO);
       
    }

    public boolean delete(trEstadoCivilDTO trEstadoCivilDTO) throws Exception {
        return ecDAO.delete(trEstadoCivilDTO.getTrIdCatalogo());
       
    }

    public Integer getMaxRow() throws Exception {
        return ecDAO.getRowCout();
    }
        
}
