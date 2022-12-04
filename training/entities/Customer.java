package r2s.training.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name, phone, address;
    private List<Order> order = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String phone, String address, List<Order> order) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
