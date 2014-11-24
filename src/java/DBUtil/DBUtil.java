/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Phat Ashley Yonas
 */
public class DBUtil {
        //sql query to manip.
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        static final String DB_URL = "jdbc:mysql://localhost/PaytoSteal";
        static final String USER = "root";
        static final String PASS = "";
    
    public String sqlTest(){
        
        
        try{
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From customer");
            String test = rs.getString("firstName");
            try{
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return test;
        }
        catch(SQLException e){
            for(Throwable t: e)
                t.printStackTrace();
        }
        return "nothing";
    }
}
