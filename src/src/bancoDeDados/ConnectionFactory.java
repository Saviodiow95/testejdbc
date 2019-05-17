
package src.bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/jdbc","root",""); 
            
            
        } catch (ClassNotFoundException ex) {
            throw  new SQLException(ex.getMessage());
        }  
    }
    
}
