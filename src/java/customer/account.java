/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

/**
 *
 * @author Phat
 */
public class account {
    String firstName;
    String lastName;
    String password;
    //request.setAttribute("firstName", firstName);
    public account(String first, String last, String pw){
        firstName=first;
        lastName=last;
        password=pw;
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
