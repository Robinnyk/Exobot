import trDataAcces.trSexoDAO;
import trDataAcces.trDTO.trSexoDTO;

public class App {
    public static void main(String[] args) throws Exception {
        

        try {
            trSexoDAO sexoDAO = new trSexoDAO();
            for (trSexoDTO s: sexoDAO.readAll()) {
                System.out.println(s.toString());
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
}
