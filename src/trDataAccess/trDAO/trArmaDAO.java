package trDataAccess.trDAO;

import trDataAccess.trDTO.trArmaDTO;
import trDataAccess.Helpers.trSQLiteDataHelper;
import trInfrastructure.AppException;

public class trArmaDAO extends trSQLiteDataHelper<trArmaDTO> {
    public trArmaDAO() throws AppException {
        super(trArmaDTO.class, "trArma", "trIdArma");
    }
}
