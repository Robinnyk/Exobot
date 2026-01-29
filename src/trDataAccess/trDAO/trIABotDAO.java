package trDataAccess.trDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trDataAccess.trDTO.trIABotDTO;
import trDataAccess.Helpers.trSQLiteDataHelper;
import trInfrastructure.AppException;

public class trIABotDAO extends trSQLiteDataHelper<trIABotDTO> {

    public trIABotDAO() throws AppException {
        super(trIABotDTO.class, "trIABot", "trIdIABot");
    }

    @Override
    public boolean create(trIABotDTO entity) throws AppException {
        String sql = "INSERT INTO trIABot (trNombre, trObservacion) VALUES (?, ?)";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, entity.getTrNombre());
            stmt.setString(2, entity.getTrObservacion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "create");
        }
    }

    @Override
    public boolean update(trIABotDTO entity) throws AppException {
        String sql = "UPDATE trIABot SET trNombre = ?, trObservacion = ? WHERE trIdIABot = ?";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, entity.getTrNombre());
            stmt.setString(2, entity.getTrObservacion());
            stmt.setInt(3, entity.getTrIdIABot());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "update");
        }
    }

    @Override
    public boolean delete(Integer id) throws AppException {
        String sql = "DELETE FROM trIABot WHERE trIdIABot = ?";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "delete");
        }
    }

    @Override
    public trIABotDTO readBy(Integer id) throws AppException {
        String sql = "SELECT * FROM trIABot WHERE trIdIABot = ?";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? mapResultSetToEntity(rs) : null;
            }
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "readBy");
        }
    }

    @Override
    public List<trIABotDTO> readAll() throws AppException {
        List<trIABotDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM trIABot";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "readAll");
        }
        return list;
    }

    @Override
    public Integer getCountReg() throws AppException {
        String sql = "SELECT COUNT(*) FROM trIABot";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getCountReg");
        }
    }

    @Override
    public Integer getMaxReg(String tableCelName) throws AppException {
        String sql = String.format("SELECT MAX(%s) FROM trIABot", tableCelName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getMaxReg");
        }
    }

    @Override
    public Integer getMinReg(String tableCelName) throws AppException {
        String sql = String.format("SELECT MIN(%s) FROM trIABot", tableCelName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getMinReg");
        }
    }
}
