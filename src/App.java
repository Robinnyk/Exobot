import java.awt.SplashScreen;

import trBusinessLogic.trEntities.trEstadoCivilBL;
import trBusinessLogic.trEntities.trPersonaTipoBL;
import trBusinessLogic.trEntities.trSexoBL;
import trDataAccess.trEstadoCivilDAO;
import trDataAccess.trPersonaTipoDAO;
import trDataAccess.trSexoDAO;
import trDataAccess.trDTO.trEstadoCivilDTO;
import trDataAccess.trDTO.trPersonaTipoDTO;
import trDataAccess.trDTO.trSexoDTO;
import trUserInterface.trForms.trMainForm;
import trUserInterface.trForms.trSplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        

        try {
            trSexoDAO sexoDAO = new trSexoDAO();
            for (trSexoDTO s: sexoDAO.readAll()) {
                System.out.println(s.toString());
            }

            System.err.println("------------------------------------------------------------");

            trEstadoCivilDAO estadoCivilDAO = new trEstadoCivilDAO();
            for (trEstadoCivilDTO eC: estadoCivilDAO.readAll()) {
                System.out.println(eC.toString());
            }

            System.err.println("------------------------------------------------------------");

            trPersonaTipoDAO personaTipoDAO = new trPersonaTipoDAO();
            for (trPersonaTipoDTO pT: personaTipoDAO.readAll()) {
                System.out.println(pT.toString());
            }

            System.err.println("------------------------------------------------------------");

            // Test: BL
            // Testing Business Logic Layer Sexo
            
            try {

                int a[] = {10,0},  b = 10;
                // Refactor hizo un try catch para que la division no dañe el codigo y genere un exception (error).
                try {
                    // int resultadoA = a[100]/b;   // El error se produce aquí.
                    int resultadoA = a[1]/b;
                    // int resultadoB = b/ a[0];    // El error se produce aquí.
                    int resultadoB = b/ a[0];
                    throw new Exception("Te quiero fregar la vida"); // Como ninguna genera error, se llega a esta línea (y esta va directo al exception general).
                    // Burbujear: "Genero la excepción y la tengo que inyectar en el flujo del proceso."
                    // Burbujear: "Yo no se que hacer con el error, pero te lo paso/informo a ti para que lo trates (osea que el programa manda a los catch).@"
                    // throw: se genera la excepción pero se cuelga el programa.

                    // En algunos casos, se inyecta a proposito una excepción para que el flujo del programa la maneje.

                } catch (ArithmeticException e) {
                    // e.printStackTrace();            // Esto solo atrapa el error y no lo notifica.
                    System.out.println("Error: No se puede dividir por cero... "); // + e.getMessage());

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Esta fuera del rango... "); // + e.getMessage());
                    
                } catch (Exception e) {
                    System.out.println("Ups.. se produjo un error inesperado: "); // + e.getMessage());
                    
                } finally {
                    // Codigo que se ejecutará siempre, incluso si se produjo una excepción.
                    // Liberar recursos.
                    b = 10;    // Da igual poner la variable b aqui, pq sin errores igual se ejecuta.
                    System.out.println("Operacion finalizada (ejecución con o sin error).");
                    System.err.println("------------------------------------------------------------");

                }
                b = 10;  // Tambien se puede poner aqui, pq si no hay errores se ejecuta igual.

                trSexoBL sexoBL = new trSexoBL();
                // sexoBL.add(new trSexoDTO(0,0,"nuevo sexo","prueba",null,null,null));
                for (trSexoDTO s: sexoBL.getAllSexos()) {
                    System.out.println(s.toString());
                }

            }catch (Exception e) {
                System.out.println(e.toString());
            }

            System.err.println("------------------------------------------------------------");
            
            // Testing Business Logic Layer Estado Civil
            
            trEstadoCivilBL estadoCivilBL = new trEstadoCivilBL();
            for (trEstadoCivilDTO eC: estadoCivilBL.getAllEstadoCivil()) {
                System.out.println(eC.toString());
            }

            System.err.println("------------------------------------------------------------");

            // Testing Business Logic Layer Persona Tipo
            trPersonaTipoBL personaTipoBL = new trPersonaTipoBL();
            for (trPersonaTipoDTO pT: personaTipoBL.getAllPersonaTipo()) {
                System.out.println(pT.toString());
            }

            System.err.println("------------------------------------------------------------");

            trSplashScreenForm.show();
            trMainForm frMain = new trMainForm("IABot - ExoBot");
            

        }catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
}
