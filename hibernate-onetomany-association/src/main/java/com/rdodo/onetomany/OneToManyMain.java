package com.rdodo.onetomany;

import com.rdodo.onetomany.model.Cart;
import com.rdodo.onetomany.model.Product;
import com.rdodo.onetomany.utils.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMain {
    public static void main(String[] args) {
        //addData();
        fetchCart();
    }

    private static void addData () {
        Cart cart = new Cart();
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("Apple", 155, cart));
        productList.add(new Product("Mango", 100, cart));
        productList.add(new Product("Banana", 25, cart));
        productList.add(new Product("Gwava", 55, cart));

        cart.setProductList(productList);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        for (Product product: productList) {
            session.persist(product);
        }

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }


    private static void fetchCart() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = session.get(Cart.class, 2);

        System.out.println("======================Cart==============================");
        System.out.println(cart.getId() + " : "+ cart.getAmount());
        System.out.println("=======================End==============================");

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
