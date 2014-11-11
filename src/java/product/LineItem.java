/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;

/**
 *
 * @author Ashley, Phat, Yonas
 */
public class LineItem implements Serializable{
    private Item item;
    private int quantity;
    
    public LineItem() {
        item = null;
        quantity = 0;
    }
    
    public LineItem(Item p, int num) {
        item = p;
        quantity = num;
    }
    
    public void setItem(Item p) {
        item = p;
    }
    public Item getItem() {
        return item;
    }
    
    public void setQuantity(int num) {
        quantity = num;
    }
    public int getQuantity() {
        return quantity;
    }
    
    public void incQuantity() {
        quantity += 1;
}
}
