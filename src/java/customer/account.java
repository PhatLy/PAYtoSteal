/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;
import java.sql.*;
import java.sql.ResultSet;
/**
 *
 * @author Phat Ashley Yonas
 */
public class account {
    //sql query to manip.
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/PaytoSteal";
    static final String USER = "root";
    static final String PASS = "";
    
    String firstName;
    String lastName;
    String country;
    String email;
    String username;
    String password;    
    
    public account(String first, String last, String pw, String ctr, String em, String un){
        firstName=first;
        lastName=last;
        password=pw;
        country=ctr;
        email=em;
        username=un;
        
    }
    public String getFirst(){
        return firstName;
    }
    public String getLast(){
        return lastName;
    }
    public String getPw(){
        return password;
    }
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