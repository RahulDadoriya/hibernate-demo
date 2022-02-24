package com.rdodo.association;

import com.rdodo.association.model.Person;
import com.rdodo.association.model.Vehicle;
import com.rdodo.association.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOneMain {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Bike", 1323D);
        Person person = new Person("Anna Parker", "9098789876", vehicle);

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        // session.persist(person);

        Person fetchPerson = session.get(Person.class, 5);
        System.out.println("=======================================");
        System.out.println(fetchPerson.toString());
        System.out.println("========================================");
        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
