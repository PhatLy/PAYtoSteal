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
    private String orderNumber;
    private int itemSku;
    private String itemName;
    private double price;
    private int quantity;

    public LineItem() {
        orderNumber = "";
        itemSku = 0;
        itemName = "";
        price = 0;
        quantity = 0;
    }

    public int getItemSku() {
        return itemSku;
    }

    public void setItemSku(int itemSku) {
        this.itemSku = itemSku;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incQuantity() {
        quantity += 1;
    }
}
