package trBusinessLogic.trEntities;

import trBusinessLogic.trInterfaces.trIIAEXO;
import trInfrastructure.Tools.ExoTracer;

public class trIAExo implements trIIAEXO {

    public void trEjecutarAccion() {
        ExoTracer.trGood("IAExo ejecutando acción");
    }
    
}
