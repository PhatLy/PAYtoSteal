/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phat Ashley Yonas
 */
public class countries {
    List<String> country;
    public countries(){
        country = new ArrayList<String>();
                country.add("United States");
                country.add("Mexico");
                country.add("Canada");
                country.add("Russia");
    }
    public List<String> getCountries(){
        return country;
    }
}
