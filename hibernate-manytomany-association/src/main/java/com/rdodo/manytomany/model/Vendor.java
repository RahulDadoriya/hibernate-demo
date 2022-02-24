package com.rdodo.manytomany.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vendor {
    @Id
    @Column(name = "vendor_id")
    @GenericGenerator(name = "custom-id-generator", strategy = "com.rdodo.manytomany.idgenerator.CustomIdGenerator")
    @GeneratedValue(generator = "custom-id-generator")
    private int id;
    private String vendorName;
    private int vendorContact;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Customer> customerList;

    public Vendor() {
    }

    public Vendor(String vendorName, int vendorContact) {
        this.vendorName = vendorName;
        this.vendorContact = vendorContact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getVendorContact() {
        return vendorContact;
    }

    public void setVendorContact(int vendorContact) {
        this.vendorContact = vendorContact;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
