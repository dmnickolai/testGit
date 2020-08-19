/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class SqliteDB {
    Connection dbConn = null;
    Statement stat = null;
SqliteDB(){
    
         try {
             Class.forName("org.sqlite.JDBC");
             dbConn = DriverManager.getConnection("jdbc:sqlite:C:\\users\\Dennis\\firstDB.db");
             System.out.println("SQLite Connection OK");
getNames();


             //dbConn.close();
         }
         catch (SQLException ex){
             System.out.println(ex.getMessage());
             System.exit(1);
         }
        catch (Exception ex){
             System.out.println(ex.getMessage());
             System.exit(1); 
         }
    } 

    public void getNames() {
        try {
            stat = dbConn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM myfirsttable;");
            while(rs.next()) {
                String ln = rs.getString(2);
                String fn = rs.getString(3);
                System.out.println(ln + ", " + fn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqliteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
