import trApp.trDesktopApp.trForms.AppSplashScreen;
import trApp.trDesktopApp.trForms.AppStart;
import trInfrastructure.AppAutenticator;

public class App {
    public static void main(String[] args) {

    
        try {
            if (!AppAutenticator.trAutenticar()) {
                System.err.println("Máximo de intentos alcanzado. Saliendo...");
                return;
            }
            new AppSplashScreen();
            new AppStart("ExoTrooper");

        } catch (Exception e) { 
        }
    }
}