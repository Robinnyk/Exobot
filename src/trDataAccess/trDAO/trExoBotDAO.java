package trDataAccess.trDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trDataAccess.trDTO.trExoBotDTO;
import trDataAccess.Helpers.trSQLiteDataHelper;
import trInfrastructure.AppException;

public class trExoBotDAO extends trSQLiteDataHelper<trExoBotDTO> {

    public trExoBotDAO() throws AppException {
        super(trExoBotDTO .class, "trExoBot", "trIdExobot");
    }
    
    public List<trExoBotDTO> trReadByTipoExobot(String tipoExobot) throws AppException {
        List<trExoBotDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM trExoBot WHERE trNombre = ?";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, tipoExobot);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) list.add(mapResultSetToEntity(rs));
            }
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "trReadByTipoExobot");
        }
        return list;
    }
}
