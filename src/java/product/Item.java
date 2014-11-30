/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ashley, Yonas, Phat
 */
public class Item implements Serializable {
    private int sku;
    private String imgSrc;
    private String itemName;
    private double price;
    private String description;
    private double discount;
    private Date discountStartTime;
    private Date discountEndTime;

    public Item() {
        sku = 0;
        imgSrc = "images/noItem.png";
        itemName = "";
        price = 0;
        description = "";
        discount = 0;
        discountStartTime = new Date();
        discountEndTime = new Date();
    }

    public Item(int sku, String imgSrc, String itemName, double price, String description, double discount, Date discountStartTime, Date discountEndTime) {
        this.sku = sku;
        this.imgSrc = imgSrc;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.discountStartTime = discountStartTime;
        this.discountEndTime = discountEndTime;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double amt) {
        price = amt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDiscountStartTime() {
        return discountStartTime;
    }

    public void setDiscountStartTime(Date discountStartTime) {
        this.discountStartTime = discountStartTime;
    }

    public Date getDiscountEndTime() {
        return discountEndTime;
    }

    public void setDiscountEndTime(Date discountEndTime) {
        this.discountEndTime = discountEndTime;
    }
}