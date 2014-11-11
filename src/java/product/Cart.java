/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Ashley, Phat, Yonas
 */
public class Cart implements Serializable{
    private ArrayList<LineItem> items;
    
    public Cart() {
        items = new ArrayList<>();
    }
    
    public int getSize() {
        return items.size();
    }
    
    public ArrayList<LineItem> getItems(){
        return items;
    }
    
    public void addItem(LineItem p) {
        if (items.contains(p)) {
            int i = items.indexOf(p);
            LineItem lItem = items.get(i);
            lItem.incQuantity();
        }
        else {
            items.add(p);
            p.incQuantity();
        }
    }
    
    public void removeItem(LineItem p) {
        items.remove(p);
    }
    
    public void emptyCart() {
        items.clear();
    }
}
