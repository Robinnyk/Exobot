package trDataAccess.trDAO;

import trDataAccess.Helpers.trSQLiteDataHelper;
import trDataAccess.trDTO.trPersonaTipoDTO;
import trInfrastructure.AppException;


public class trPersonaTipoDAO extends trSQLiteDataHelper<trPersonaTipoDTO>{
    public trPersonaTipoDAO() throws AppException {
        super(trPersonaTipoDTO.class, "trPersonaTipo", "trIdPersonaTipo");
    }
}

