package com.rdodo.onetomany.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private int id;
    private double amount;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cart", fetch = FetchType.LAZY)
    private List<Product> productList;

    public Cart() {
    }

    public Cart(List<Product> productList) {
        this.amount = productList.stream().mapToDouble(Product::getPrice).sum();
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.amount = productList.stream().mapToDouble(Product::getPrice).sum();
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", amount=" + amount +
                ", productList=" + productList +
                '}';
    }
}
