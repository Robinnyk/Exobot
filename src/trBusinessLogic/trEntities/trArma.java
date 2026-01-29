package trBusinessLogic.trEntities;

import trInfrastructure.Tools.ExoTracer;

public class trArma {
    
    private String trMunision;
    private String trTipoArma;
   

    public String getTrMunision() {
        return trMunision;
    }

    public void setTrMunision(String trMunision) {
        this.trMunision = trMunision;
    }

    public String getTrTipoArma() {
        return trTipoArma;
    }

    public void setTrTipoArma(String trTipoArma) {
        this.trTipoArma = trTipoArma;
    }

    public trArma() {}

    public trArma(String tipoArma, String municion) {
        trTipoArma = tipoArma;
        trMunision = municion;
    }

    
    public void trDisparar() {
        ExoTracer.trGood("El arma " + trTipoArma + " está ejecutando la acción: disparar");
    }

   
    @Override
    public String toString() {
        return getClass().getSimpleName()
            + "\n trTipoArma: " + trTipoArma
            + "\n trMunicion: " + trMunision;
    }

}
