package trDataAccess.trDAO;

import trDataAccess.Helpers.trSQLiteDataHelper;
import trDataAccess.trDTO.trCatalogoTipoDTO;
import trInfrastructure.AppException;


public class trCatalogoTipoDAO extends trSQLiteDataHelper<trCatalogoTipoDTO>{
    public trCatalogoTipoDAO() throws AppException {
        super(trCatalogoTipoDTO.class, "trCatalogoTipo", "trIdCatalogoTipo");
    }
}

