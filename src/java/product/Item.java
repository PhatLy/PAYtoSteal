/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;

/**
 *
 * @author Ashley, Yonas, Phat
 */
public class Item implements Serializable{
    private String imgSrc;
    private String itemName;
    private String price;
    private String description;
    
    public Item(){
        imgSrc = "images/noItem.png";
        itemName = "";
        price = "";
        description = "";
    }
    
    public Item(String src, String nme, String amt, String desc) {
        imgSrc = src;
        itemName = nme;
        price = amt;
        description = desc;
    }
    
    public String getImgSrc() {
        return imgSrc;   
    }
    public void setImgSrc(String src) {
        imgSrc = src;
    }
    
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String nme) {
        itemName = nme;
    }
    
    public String getPrice() {
        return price;
    }
    public void setPrice(String amt) {
        price = amt;
    }
    
    public String getDescription() {
        return description;   
    }
    public void setDescription(String desc) {
        description = desc;
    }
}
