/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Maurinho
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    public Connection conectar()
    {
        Connection cn = null;
        try
        {
             JOptionPane.showMessageDialog(null, "A basic JOptionPane message dialog");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://server\\SQLEXPRESS;databaseName=pegasus;integratedSecurity=true;");
    
        }   
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
}
