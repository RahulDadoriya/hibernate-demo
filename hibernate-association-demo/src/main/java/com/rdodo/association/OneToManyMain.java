package com.rdodo.association;

import com.rdodo.association.model.Cart;
import com.rdodo.association.model.Product;
import com.rdodo.association.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMain {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Banana", 25));
        productList.add(new Product("Apple", 155));
        productList.add(new Product("Guava", 50));

        Cart cart = new Cart(productList);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(cart);

//        Cart cart1 = session.get(Cart.class, 1);
//        System.out.println("=======================================");
//        System.out.println(cart1.toString());
//        System.out.println(cart1.getProductList());

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();

    }
}
