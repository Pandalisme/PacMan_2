/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Connector {
    private static String server = "jdbc:mysql://localhost/db_pacman";
    private static String username = "root";
    private static String password ="";
    private static Connection connection;
    
    public static Connection getConnection(){
        if(connection==null){
            connection = LogOn();
        }
        return connection;
    }
    
    private static Connection LogOn() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Sukses");
            return DriverManager.getConnection(server,username,password);
        }
        catch(SQLException e){
            e.printStackTrace(System.err);
            System.out.println("Gagal"+e.toString());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }
    
    private static void LogOff(){
        try{
            connection.close();
            System.out.println("Koneksi close");
        }
        catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
   
    
    
}
