package trBusinessLogic.trEntities;

import java.util.List;

import trDataAcces.trSexoDAO;
import trDataAcces.trDTO.trSexoDTO;

public class trSexoBL {

    private trSexoDTO sexo;
    private trSexoDAO sDAO = new trSexoDAO();

    public trSexoBL() {}

    public List<trSexoDTO> getAllSexos() throws Exception {

        // Regla de negocio: Convertir el nombre del sexo a mayúsculas
        
        List<trSexoDTO> lst = sDAO.readAll();
        for (trSexoDTO sDto : lst) {
            sDto.setTrNombre(sDto.getTrNombre().toUpperCase());
        }
        return lst;
    }

    public trSexoDTO getSexoById(Integer id) throws Exception {
        sexo = sDAO.readBy(id);
        return sexo;
    }
    
    public boolean create(trSexoDTO trSexoDTO) throws Exception {
        return sDAO.create(trSexoDTO);       

    }

    public boolean update(trSexoDTO trSexoDTO) throws Exception {
        return sDAO.update(trSexoDTO);
       
    }

    public boolean delete(trSexoDTO trSexoDTO) throws Exception {
        return sDAO.delete(trSexoDTO.getTrIdCatalogo());
       
    }

    public Integer getMaxRow() throws Exception {
        return sDAO.getRowCout();
    }
        

}
