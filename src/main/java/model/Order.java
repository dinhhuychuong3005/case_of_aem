package model;

import java.sql.Date;

public class Order {
    private int orderId;
    private Date date;
    private  int customerId;
    private int isPay;

    public Order(Date date, int customerId, int isPay) {
        this.date = date;
        this.customerId = customerId;
        this.isPay = isPay;
    }

    public Order(int orderId, Date date, int customerId, int isPay) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.isPay = isPay;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }
}
