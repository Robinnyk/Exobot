package trDataAccess.trDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trDataAccess.trDTO.trPersonaDTO;
import trDataAccess.Helpers.trSQLiteDataHelper;
import trInfrastructure.AppException;

public class trPersonaDAO extends trSQLiteDataHelper<trPersonaDTO> {

    public trPersonaDAO() throws AppException {
        super(trPersonaDTO.class, "trPersona", "trIdPersona");
    }

    @Override
    public boolean create(trPersonaDTO entity) throws AppException {
        String sql = "INSERT INTO trPersona (trIdCatalogoTipoPersona, trIdCatalogoSexo, trIdCatalogoEstadoCivil, trCedula, trNombre, trApellido) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setInt(1, entity.getTrIdCatalogoTipoPersona());
            stmt.setInt(2, entity.getTrIdCatalogoSexo());
            stmt.setInt(3, entity.getTrIdCatalogoEstadoCivil());
            stmt.setString(4, entity.getTrCedula());
            stmt.setString(5, entity.getTrNombre());
            stmt.setString(6, entity.getTrApellido());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "create");
        }
    }

    @Override
    public boolean update(trPersonaDTO entity) throws AppException {
        String sql = "UPDATE trPersona SET trIdCatalogoTipoPersona = ?, trIdCatalogoSexo = ?, trIdCatalogoEstadoCivil = ?, trCedula = ?, trNombre = ?, trApellido = ? WHERE trIdPersona = ?";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setInt(1, entity.getTrIdCatalogoTipoPersona());
            stmt.setInt(2, entity.getTrIdCatalogoSexo());
            stmt.setInt(3, entity.getTrIdCatalogoEstadoCivil());
            stmt.setString(4, entity.getTrCedula());
            stmt.setString(5, entity.getTrNombre());
            stmt.setString(6, entity.getTrApellido());
            stmt.setInt(7, entity.getTrIdPersona());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "update");
        }
    }

    @Override
    public boolean delete(Integer id) throws AppException {
        String sql = "DELETE FROM trPersona WHERE trIdPersona = ?";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "delete");
        }
    }

    @Override
    public trPersonaDTO readBy(Integer id) throws AppException {
        String sql = "SELECT * FROM trPersona WHERE trIdPersona = ?";
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
    public List<trPersonaDTO> readAll() throws AppException {
        List<trPersonaDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM trPersona";
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
        String sql = "SELECT COUNT(*) FROM trPersona";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getCountReg");
        }
    }

    @Override
    public Integer getMaxReg(String tableCelName) throws AppException {
        String sql = String.format("SELECT MAX(%s) FROM trPersona", tableCelName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getMaxReg");
        }
    }

    @Override
    public Integer getMinReg(String tableCelName) throws AppException {
        String sql = String.format("SELECT MIN(%s) FROM trPersona", tableCelName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getMinReg");
        }
    }
}
