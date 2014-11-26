/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.util;

import product.*;

/**
 *
 * @author Ashley
 */
public class ProdMgmt {
    public Item[] getItems() {
        Item[] items = {new Item("images/iphone.jpg","Apple iPhone",199.99,""), 
                        new Item("images/textbook.jpg","Textbook",100.00,""),
                        new Item("images/fan.jpg","Desk Fan",23.99,"")};
        
        return items;
    }
    
}
