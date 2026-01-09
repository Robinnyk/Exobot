import trDataAcces.trEstadoCivilDAO;
import trDataAcces.trPersonaTipoDAO;
import trDataAcces.trSexoDAO;
import trDataAcces.trDTO.trEstadoCivilDTO;
import trDataAcces.trDTO.trPersonaTipoDTO;
import trDataAcces.trDTO.trSexoDTO;

public class App {
    public static void main(String[] args) throws Exception {
        

        try {
            trSexoDAO sexoDAO = new trSexoDAO();
            for (trSexoDTO s: sexoDAO.readAll()) {
                System.out.println(s.toString());
            }

            System.out.println("---------------------");

            trEstadoCivilDAO estadoCivilDAO = new trEstadoCivilDAO();
            for (trEstadoCivilDTO eC: estadoCivilDAO.readAll()) {
                System.out.println(eC.toString());
            }

            System.out.println("---------------------");

            trPersonaTipoDAO personaTipoDAO = new trPersonaTipoDAO();
            for (trPersonaTipoDTO pT: personaTipoDAO.readAll()) {
                System.out.println(pT.toString());
            }
            

        }catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
}
