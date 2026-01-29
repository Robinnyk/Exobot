package trDataAccess.trDAO;

import trDataAccess.Helpers.trSQLiteDataHelper;
import trDataAccess.trDTO.trCatalogoDTO;
import trInfrastructure.AppException;


public class trCatalogoDAO extends trSQLiteDataHelper<trCatalogoDTO>{
    public trCatalogoDAO() throws AppException {
        super(trCatalogoDTO.class, "trCatalogo", "trIdCatalogo");
    }
}

