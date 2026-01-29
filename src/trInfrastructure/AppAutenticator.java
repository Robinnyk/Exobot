package trInfrastructure;

import trInfrastructure.Tools.CMDInput;
import trInfrastructure.Tools.CMDProgress;
import trInfrastructure.Tools.ExoTracer;

/**
 * Autenticación por consola: cédula y clave. Acceso de prueba: patmic / 123. Máximo 3 intentos.
 * En consola y ExoTracer.txt: GOOD : Acceso concedido | ERROR: Acceso denegado.
 */
public abstract class AppAutenticator {
    private static final String TR_USER = "patmic";
    private static final int TR_MAX_INTENTOS = 3;

    private AppAutenticator() {}

    public static boolean trAutenticar() {
        
        try {
        
        System.out.println("");
        System.out.println("Iniciando Programa ExoBot...");
        CMDProgress.showSpinner();
        System.out.println("\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------");
        System.out.println("                    EXOBOT                       ");
        System.out.println("-------------------------------------------------");

        for (int i = 1; i <= TR_MAX_INTENTOS; i++) {
            String cedula = CMDInput.getCaracteres("Usuario: ");
            String clave  = CMDInput.getCaracteres("Constraseña: ");
            if (TR_USER.equals(cedula) && "123".equals(clave)) {
                ExoTracer.trGood("Acceso concedido");
                return true;
            }
            ExoTracer.trError("Acceso denegado.");
        }
        return false;
    }
}
