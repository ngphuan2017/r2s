package r2s.training.entities;

import java.util.Date;

public class Order {
    private String number;
    Date date;
    private Double price;
    private Integer quantity;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Order(){}

    public Order(String number, Date date, Double price, Integer quantity) {
        this.number = number;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }
}
