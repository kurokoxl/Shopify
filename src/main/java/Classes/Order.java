package Classes;

import java.sql.Date;

public class Order {
    private static int nextId = 1;
    private int id;
    private double totalPrice;
    private String name;

    private String status;
    private Cart cart;

    //Add private User user (When implemented) but why user here;
    private Date estimatedDelivery;

    //no need for a cart in order;
    /*private Cart cart;
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }*/


    public Order(){}
    public Order(double totalPrice,Cart cart) {
        this.id = nextId++;
        this.totalPrice=totalPrice;
        this.cart=cart;
//        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(Date estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
