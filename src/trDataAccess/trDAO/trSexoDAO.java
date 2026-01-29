package trDataAccess.trDAO;

import trDataAccess.trDTO.trSexoDTO;
import trDataAccess.Helpers.trSQLiteDataHelper;
import trInfrastructure.AppException;

public class trSexoDAO extends trSQLiteDataHelper<trSexoDTO>{
    public trSexoDAO() throws AppException {
        super(trSexoDTO.class, "trSexo", "trIdSexo");
    }
}

