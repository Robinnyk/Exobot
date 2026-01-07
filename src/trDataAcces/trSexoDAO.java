package trDataAcces;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import trDataAcces.trDTO.trSexoDTO;


public class trSexoDAO extends trSQLiteDataHelper implements trIDAO<trSexoDTO> {

    @Override
    public boolean create(trSexoDTO entity) throws Exception {
        
        String query = "INSERT INTO Sexo (Nombre_sexo) VALUES (?)";
       
        try {
            Connection conn = trOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.gettrNombre());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e;
        }

    }

    @Override
    public List<trSexoDTO> readAll() throws Exception {
        
        List <trSexoDTO> listaSexos = new ArrayList<>();
        String query = "SELECT id_sexo"
                    + ", Nombre_sexo"
                    + ", Estado_sexo"
                    + ", Fecha_creacion"
                    + ", Fecha_modificacion"
                    + " FROM Sexo"
                    + " WHERE Estado_sexo = 'A'";


        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                trSexoDTO sexo = new trSexoDTO(rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5));
                
                listaSexos.add(sexo);
            }

        } catch (SQLException e) {
            throw e;
        }

        return listaSexos;
    }

    @Override
    public boolean update(trSexoDTO entity) throws Exception {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Sexo SET Nombre_sexo = ?,"
                        + " Fecha_modificacion = ?"
                        + " WHERE id_sexo = ?;";

        try {
            Connection conn = trOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.gettrNombre());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.gettrIdSexo());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e;
        }

    }

    @Override
    public boolean delete(Integer id) throws Exception {
       
        String query = "UPDATE Sexo SET Estado_sexo = ? WHERE id_sexo = ?;";
        
        try {
            Connection conn = trOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public trSexoDTO readBy(Integer id) throws Exception {

        trSexoDTO oS = new trSexoDTO();
        String query = "SELECT id_sexo"
                    + ", Nombre_sexo"
                    + ", Estado_sexo"
                    + ", Fecha_creacion"
                    + ", Fecha_modificacion"
                    + " FROM Sexo"
                    + " WHERE Estado_sexo = 'A' AND id_sexo = " + id;

        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                oS = new trSexoDTO(rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5));
                
            }

        } catch (SQLException e) {
            throw e;
        }

        return oS;
        
    }

    @Override
    public Integer getMaxReg() throws Exception {
        
        String query = "SELECT COUNT(*) TotalReg FROM Sexo "
                        + " WHERE Estado_sexo = 'A';";

        try {
            Connection conn = trOpenConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
            
        } catch (SQLException e) {
            throw e;

        }
        return 0;

    }

}
