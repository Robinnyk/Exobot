package trBusinessLogic.trEntities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trDataAcces.trSexoDAO;
import trDataAcces.trDTO.trSexoAnteDTO;
import trDataAcces.trDTO.trSexoDTO;

public class trSexoBL {

    private trSexoDTO sexo;
    private trSexoDAO sDAO = new trSexoDAO();

    public trSexoBL() {}

    public List<trSexoDTO> getAllSexos() throws Exception {
        return sDAO.readAll();
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
