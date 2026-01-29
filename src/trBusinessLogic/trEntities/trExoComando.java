package trBusinessLogic.trEntities;

import trInfrastructure.Tools.ExoMunisionHelper;
import trInfrastructure.Tools.ExoTracer;

public class trExoComando extends trExoBot {

    private trArma trArma;

    public trArma getTrArma() {
        return trArma;
    }

    public void setTrArma(trArma trArma) {
        this.trArma = trArma;
    }

    public trExoComando() {
        super("ExoMedico");
    }

    public trExoComando(trArma arma) {
        super("ExoMedico");
        this.trArma = arma;
    }

    @Override
    public void trEjecutarAccion() {
        if (trArma == null) {
            ExoTracer.trError("ExoMedico: No tiene arma asignada");
            return;
        }

        String[] info = ExoMunisionHelper.trGetForTipoExobot("ExoMedico");
        if (info == null) {
            info = ExoMunisionHelper.trGetTipoArmaAccion("ExoMedico");
            info = new String[]{info[0], info[1], "Energía"};
        }

        trArma.trDisparar();
        trInmovil = (trInmovil == null ? 0 : trInmovil) + 1;

        String mensaje = info[0] + " " + info[1] + " " + info[2];
        ExoTracer.trGood(mensaje);
    }

 
}
