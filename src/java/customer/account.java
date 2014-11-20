/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

/**
 *
 * @author Phat Ashley Yonas
 */
public class account {
    
    
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
    
}