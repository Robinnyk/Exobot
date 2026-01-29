package trBusinessLogic.trEntities;

import trInfrastructure.Tools.ExoTracer;

public class trSoldadoExperto extends trSoldado {

    private String trTipoArma;

    public String getTrTipoArma() {
        return trTipoArma;
    }

    public void setTrTipoArma(String trTipoArma) {
        this.trTipoArma = trTipoArma;
    }

    public trSoldadoExperto() {
        super();
    }

    public trSoldadoExperto(String nombre, String cedula, String tipoArma) {
        super(nombre, cedula);
        trTipoArma = tipoArma;
    }

    public void mjEntrenar(trExoBot exobot, trArma arma) {
        if (exobot == null || arma == null) {
            ExoTracer.trError(trNombre + " " + trTipoArma + " - Error en entrenamiento");
            return;
        }

        exobot.trEntrenarArma();
        ExoTracer.trGood(trNombre + " " + trTipoArma + " asistir");
    }


    @Override
    public String toString() {
        return super.toString()
            + "\n trTipoArma: " + trTipoArma;
    }
}
