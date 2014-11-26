/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import dbutil.ConnectionPool;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ashley, Yonas, Phat
 */
public class Item implements Serializable {

    //yonas: added sku, price (changed it to double)
    //discount, date, start, and end times.
    private String sku;
    private String imgSrc;
    private String itemName;
    private double price;
    private String description;
    private double discount;
    private Date discountCurrentTime;
    private Date discountStartTime;
    private Date discountEndTime;

    public Item() {
        imgSrc = "images/noItem.png";
        itemName = "";
        price = 0;
        description = "";
    }

    //Yonas: left this for compatibility with the existing cart implementation
    public Item(String src, String nme, double amt, String desc) {
        imgSrc = src;
        itemName = nme;
        price = amt;
        description = desc;
    }

    public Item(String sku, String imgSrc, String itemName, double price, String description, double discount, Date discountStartTime, Date discountEndTime) {
        this.sku = sku;
        this.imgSrc = imgSrc;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.discountCurrentTime = new java.util.Date();
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDiscountCurrentTime() {
        return discountCurrentTime;
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

    public int addItem(String sku, String imgSrc, String itemName, double price, String description, double discount, String discountStartTime, String discountEndTime) {
        int rowsAffected = 0;

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "insert into item (sku, imgSrc, itemName, price, description, discount, discountStartTime, discountEndTime ) "
                    + " values(?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = cp.connection.prepareStatement(query);
            stmt.setString(1, sku);
            stmt.setString(2, imgSrc);
            stmt.setString(3, itemName);
            stmt.setDouble(4, price);
            stmt.setString(5, description);
            stmt.setDouble(6, discount);
            stmt.setString(7, discountStartTime);
            stmt.setString(8, discountEndTime);

            rowsAffected = stmt.executeUpdate();

            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return rowsAffected;
    }

    public int updateItem(String sku, String imgSrc, String itemName, double price, String description, double discount, Date discountStartTime, Date discountEndTime) {
        int rowsAffected = 0;

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "update item set imgSrc = ?, itemName = ?, price = ?, description = ?, "
                    + "discount = ?, discountStartTime = ?, discountEndTime = ?"
                    + "where sku = ? ";

            PreparedStatement stmt = cp.connection.prepareStatement(query);
            stmt.setString(1, imgSrc);
            stmt.setString(2, itemName);
            stmt.setDouble(3, price);
            stmt.setString(4, description);
            stmt.setDouble(5, discount);
            stmt.setDate(6, (java.sql.Date) discountStartTime);
            stmt.setDate(7, (java.sql.Date) discountEndTime);
            stmt.setString(8, sku);

            rowsAffected = stmt.executeUpdate();

            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return rowsAffected;
    }

    public int deleteItem(String sku) {

        int rowsAffected = 0;

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = "delete from item where sku = ? ";

            PreparedStatement stmt = cp.connection.prepareStatement(query);
            stmt.setString(1, sku);

            rowsAffected = stmt.executeUpdate();

            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return rowsAffected;

    }

    public List<Item> listItems(int max) {

        ResultSet rs = null;
        List<Item> items = new ArrayList<Item>();
        Item it = null;

        try {
            ConnectionPool cp = new ConnectionPool();

            String query = " select i.sku, i.imgSrc, i.itemName, i.price, "
                    + "i.description, i.discount, i.discountStartTime, "
                    + "i.discountEndTime "
                    + "from item i "
                    + "order by i.discountEndTime ";

            //if max is 0 list all items
            query = max == 0 ? query : query + "limit ?";

            PreparedStatement stmt = cp.connection.prepareStatement(query);

            if (max > 0) {
                stmt.setInt(1, max);
            }

            rs = stmt.executeQuery();

            while (rs.next()) {

                it = new Item();
                it.setSku(rs.getString("sku"));
                it.setItemName(rs.getString("itemName"));
                it.setImgSrc(rs.getString("imgSrc"));
                it.setPrice(rs.getDouble("price"));
                it.setDescription(rs.getString("description"));
                it.setDiscount(rs.getDouble("discount"));
                it.setDiscountStartTime(rs.getDate("discountStartTime"));
                it.setDiscountEndTime(rs.getDate("discountEndTime"));

                items.add(it);

            }

            rs.close();
            stmt.close();
            cp.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return items;

    }

}
