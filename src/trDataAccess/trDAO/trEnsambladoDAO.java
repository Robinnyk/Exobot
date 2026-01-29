package trDataAccess.trDAO;

import trDataAccess.Helpers.trSQLiteDataHelper;
import trDataAccess.trDTO.trEnsambladoDTO;
import trInfrastructure.AppException;


public class trEnsambladoDAO extends trSQLiteDataHelper<trEnsambladoDTO>{
    public trEnsambladoDAO() throws AppException {
        super(trEnsambladoDTO.class, "trEnsamblado", "trIdEnsamblado");
    }
}

