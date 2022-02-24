package com.rdodo.manytomany;

import com.rdodo.manytomany.model.Customer;
import com.rdodo.manytomany.model.Vendor;
import com.rdodo.manytomany.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManyToManyMain {
    public static void main(String[] args) {
        // addData();
        // fetchCustomerData();
        fetchVendorData();
        HibernateUtil.closeSessionFactory();
    }

    private static void addData() {
        Customer c1 = new Customer("Alex Browning", 786868798, "B1 new road Mumbai, India");
        Customer c2 = new Customer("Anna Toor", 456868798, "New Delhi, India");
        Customer c3 = new Customer("Mac Mohan", 876868798, "Hydrabad, Telangna");

        Vendor v1 = new Vendor("Airtel", 2123232323);
        Vendor v2 = new Vendor("Oracle", 654332323);

        v1.setCustomerList(Arrays.asList(c1, c2, c3));
        v2.setCustomerList(Arrays.asList(c1, c2));

        c1.setVendorList(Arrays.asList(v1, v2));
        c2.setVendorList(Arrays.asList(v1, v2));

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(c1);
        session.persist(c2);
        session.persist(c3);

        transaction.commit();
        session.close();
    }

    private static void fetchCustomerData() {
        Session session = HibernateUtil.getSession();

        Customer customer = session.get(Customer.class, 887000035);
        System.out.println("=======================Customer========================");
        System.out.println(customer.getId() + " : " + customer.getName() + " : " + customer.getContact() + " : " + customer.getAddress());
        List<Vendor> vendorList = customer.getVendorList();
        vendorList.forEach(vendor -> {
            System.out.println(vendor.getId() + " : " + vendor.getVendorName() + " : " + vendor.getVendorContact());
        });
        System.out.println("=============================End=============================================");
        session.close();
    }

    private static void fetchVendorData() {
        Session session = HibernateUtil.getSession();

        Vendor vendor = session.get(Vendor.class, 905000012);
        System.out.println("=======================Vendor========================");
        System.out.println(vendor.getId() + " : " + vendor.getVendorName() + " : " + vendor.getVendorContact());
        List<Customer> customerList = vendor.getCustomerList();
        customerList.forEach(customer -> {
            System.out.println(customer.getId() + " : " + customer.getName() + " : " + customer.getContact() + " : " + customer.getAddress());
        });
        System.out.println("=============================End=============================================");
        session.close();
    }
}
