package trBusinessLogic.trEntities;

import trBusinessLogic.trInterfaces.trIIAEXO;
import trInfrastructure.Tools.ExoTracer;

public abstract class trExoBot implements trIIAEXO {

    protected String trTipoExobot;
    protected String trEntrenando;
    protected Integer trInmovil; 

    public String getTrTipoExobot() {
        return trTipoExobot;
    }

    public void setTrTipoExobot(String trTipoExobot) {
        this.trTipoExobot = trTipoExobot;
    }

    public String getTrEntrenando() {
        return trEntrenando;
    }

    public void setTrEntrenando(String trEntrenando) {
        this.trEntrenando = trEntrenando;
    }

    public Integer getTrInmovil() {
        return trInmovil;
    }

    public void setTrInmovil(Integer trInmovil) {
        this.trInmovil = trInmovil;
    }

    public trExoBot() {
        trEntrenando = "NO";
        trInmovil = 0;
    }

    public trExoBot(String tipoExabot) {
        this();
        trTipoExobot = tipoExabot;
    }

    public void trEntrenarArma() {
        trEntrenando = "SI";
        ExoTracer.trGood("Exobot entrenado: " + trTipoExobot);
    }

    @Override
    public abstract void trEjecutarAccion();


    @Override
    public String toString() {
        return getClass().getSimpleName()
            + "\n trTipoExobot: " + trTipoExobot
            + "\n trEntrenando: " + trEntrenando
            + "\n trInmovil: " + trInmovil;
    }
}
