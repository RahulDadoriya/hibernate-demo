package com.rdodo.manytomany.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GenericGenerator(name = "custom-id-generator", strategy = "com.rdodo.manytomany.idgenerator.CustomIdGenerator")
    @GeneratedValue(generator = "custom-id-generator")
    private int id;
    private String name;
    private int contact;
    private String address;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "customerList")
    private List<Vendor> vendorList;

    public Customer() {
    }

    public Customer(String name, int contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }
}
