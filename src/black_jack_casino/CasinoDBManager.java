package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* 
* The Casino DB Manager class creates a connection with the embedded derby database
* 
**/

public class CasinoDBManager {
    
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private static final String URL = "jdbc:derby:CasoinoD_Ebd; create=true";
    
    Connection conn;
    
    //----------------------------------------------------------------
    
    public CasinoDBManager() 
    {
        establishConnection();
    }
    
    //----------------------------------------------------------------
    
    public Connection getConnection() {
        return this.conn;
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The establish connection method attempts to create a connection with the
    * embedded database using the provided URL
    * 
    **/
    
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    //----------------------------------------------------------------
    /**
    * 
    * The close connections function closes all connections with the connected database.
    * 
    **/

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
