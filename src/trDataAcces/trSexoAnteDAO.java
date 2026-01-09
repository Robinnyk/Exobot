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
import trDataAcces.trDTO.trSexoAnteDTO;


public class trSexoAnteDAO extends trSQLiteDataHelper implements trIDAO<trSexoAnteDTO> {

    @Override
    public boolean create(trSexoAnteDTO entity) throws Exception {
        
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
    public List<trSexoAnteDTO> readAll() throws Exception {
        
        List <trSexoAnteDTO> listaSexos = new ArrayList<>();
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
                trSexoAnteDTO sexo = new trSexoAnteDTO(rs.getInt(1),
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
    public boolean update(trSexoAnteDTO entity) throws Exception {
        
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
    public boolean delete(int id) throws Exception {
       
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
    public trSexoAnteDTO readBy(Integer id) throws Exception {

        trSexoAnteDTO oS = new trSexoAnteDTO();
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
                oS = new trSexoAnteDTO(rs.getInt(1),
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
