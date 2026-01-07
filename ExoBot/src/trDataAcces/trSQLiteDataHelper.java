package trDataAcces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class trSQLiteDataHelper {

    private static final String trDBPathConnection = "jdbc:sqlite:DataBase//EXOBOT.sqlite";  // Ruta donde se encuentra la base
    private static Connection trConn = null;
    
    private DateTimeFormatter   dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    private LocalDateTime       now = LocalDateTime.now();

    protected trSQLiteDataHelper(){}   // Constructor por defecto

    protected static synchronized Connection trOpenConnection() throws Exception{  // Abre la conexión de la base de datos

        try {
            if(trConn == null)
                trConn = DriverManager.getConnection(trDBPathConnection);
        } catch (SQLException e) {
            throw e; //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return trConn;

    }

    protected static void trCloseConnection() throws Exception{

        try {
            if (trConn != null)
                trConn.close();
        } catch (Exception e) {
            throw e;//new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }

    }

    protected String getDataTimeNow() {
        return dtf.format(now).toString();
    }
}
