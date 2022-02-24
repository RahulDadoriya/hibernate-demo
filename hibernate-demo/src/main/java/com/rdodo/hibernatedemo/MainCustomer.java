package com.rdodo.hibernatedemo;

import com.rdodo.hibernatedemo.model.Address;
import com.rdodo.hibernatedemo.model.Customer;
import com.rdodo.hibernatedemo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MainCustomer {

    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        addresses.add(((new Address()).setStreet("Sanjay Park").setCity("Sonia").setState("Madhya Pradesh").setCountry("India").setZipcode(474011)));
        addresses.add(((new Address()).setStreet("Bus stand").setCity("Khera").setState("Madhya Pradesh").setCountry("India").setZipcode(4740333)));
        addresses.add(((new Address()).setStreet("train stand").setCity("Ambha").setState("Madhya Pradesh").setCountry("India").setZipcode(4740565)));

        Customer customer = new Customer();
        customer.setName("Tank Shark");
        customer.setAddresses(addresses);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //session.save(customer);
        Customer customer1 = session.get(Customer.class, 1);
        System.out.println("=====================");
        customer1.getAddresses().forEach(System.out::println);

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
