package trFramework;

public class trRBException extends Exception {

    public trRBException(String e, String clase, String metodo) {

        // Grabar en el log.

        // Lo dejaremos como comentarios por ahora (por si un hacker lee esto y les estaremos dando info, esto se enviará al log).
        System.out.println("Error App en la clase para el LOG: " + clase + ", en el método: " + metodo);
        System.out.println("Descripción del error: " + e);

    }

    @Override
    public String getMessage() {
        return "No seas sapo...";
    }

}
