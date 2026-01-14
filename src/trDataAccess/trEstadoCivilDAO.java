package trDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trDataAccess.trDTO.trEstadoCivilDTO;
import trFramework.trRBException;

public class trEstadoCivilDAO extends trSQLiteDataHelper implements trIDAO<trEstadoCivilDTO> {

    @Override
    public boolean create(trEstadoCivilDTO entity) throws Exception {

        String query = "INSERT INTO trCatalogo (trCatalogoTipo, trNombre, trDescripcion) VALUES (?, ?, ?)";
       
        try {
            Connection conn = trOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3); // Tipo 3 para Estado Civil
            pstmt.setString(2, entity.getTrNombre());
            pstmt.setString(3, entity.getTrDescripcion());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<trEstadoCivilDTO> readAll() throws Exception {

        List <trEstadoCivilDTO> listaEstadoCivil = new ArrayList<>();
        String query = "SELECT trIdCatalogo         "
                    + ", trIdCatalogoTipo           "
                    + ", trNombre                   "
                    + ", trDescripcion              "
                    + ", trEstado                   "
                    + ", trFechaCreacion            "
                    + ", trFechaModifica            "
                    + " FROM trCatalogo             "
                    + " WHERE trEstado = 'A'        "
                    + " AND trIdCatalogoTipo = 3    "; // Tipo 3 para Estado Civil
  
        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                trEstadoCivilDTO estadoCivil = new trEstadoCivilDTO( rs.getInt(1),       // trIdCatalogo
                                                rs.getInt(2),       // trIdCatalogoTipo
                                                rs.getString(3),    // trNombre
                                                rs.getString(4),    // trDescripcion
                                                rs.getString(5),    // trEstado
                                                rs.getString(6),    // trFechaCreacion
                                                rs.getString(7));   // trFechaModifica
                
                listaEstadoCivil.add(estadoCivil);
            }

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "readAll()");
        }

        return listaEstadoCivil;
    }

    @Override
    public boolean update(trEstadoCivilDTO entity) throws Exception {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE trCatalogo SET trNombre = ?, trDescripcion = ?, trFechaModifica = ? WHERE trIdCatalogo = ?;";

        try {
            Connection                  conn    = trOpenConnection();
            PreparedStatement           pstmt   = conn.prepareStatement(query);
            pstmt.setString(1, entity.getTrNombre());
            pstmt.setString(2, entity.getTrDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getTrIdCatalogo());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {

        String query = "UPDATE trCatalogo SET trEstado = ? WHERE trIdCatalogo = ?;";
        
        try {
            Connection conn = trOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public trEstadoCivilDTO readBy(Integer id) throws Exception {

        trEstadoCivilDTO s = new trEstadoCivilDTO();
        String query = "SELECT trIdCatalogo"
                    + ", trIdCatalogoTipo"
                    + ", trNombre"
                    + ", trDescripcion"
                    + ", trEstado"
                    + ", trFechaCreacion"
                    + ", trFechaModifica"
                    + " FROM trCatalogo"
                    + " WHERE trEstado = 'A'"
                    + " AND trIdCatalogoTipo = 3" // Tipo 3 para Estado Civil
                    + " AND trIdCatalogo = " + id.toString();
  
        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                s = new trEstadoCivilDTO( rs.getInt(1),       // trIdCatalogo
                                          rs.getInt(2),       // trIdCatalogoTipo
                                          rs.getString(3),    // trNombre
                                          rs.getString(4),    // trDescripcion
                                          rs.getString(5),    // trEstado
                                          rs.getString(6),    // trFechaCreacion
                                          rs.getString(7));   // trFechaModifica
                
            }

        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "readBy()");
        }

        return s;
    }

    public Integer getRowCout() throws Exception {

        String query = "SELECT COUNT(*) TotalReg "
                     + "FROM trCatalogo "
                     + " AND trIdCatalogoTipo = 3" 
                     + " WHERE trEstado = 'A';";

        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
            
        } catch (SQLException e) {
            throw new trRBException(e.getMessage(), getClass().getName(), "getRowCout()");

        }
        return 0;
    }


}
