package com.rdodo.association.model;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;
    private double amount;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
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
        double total = 0;
        for (Product product: productList) {
            total = total + product.getPrice();
        }
        return total;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
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
