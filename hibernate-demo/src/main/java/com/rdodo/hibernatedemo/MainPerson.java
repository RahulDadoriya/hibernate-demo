package com.rdodo.hibernatedemo;

import com.rdodo.hibernatedemo.model.Address;
import com.rdodo.hibernatedemo.model.Person;
import com.rdodo.hibernatedemo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainPerson {
    public static void main(String[] args) {
        Person person = (new Person()).setName("Mohan Sharma").setContact("787877898787")
                .setAddress((new Address()).setStreet("Kabreer Park").setCity("Gwalior").setState("Madhya Pradesh").setCountry("India").setZipcode(474011));

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //session.persist(person);

        Person fetchedPerson = session.get(Person.class, 1);
        System.out.println(fetchedPerson);

        //To update the fetched person
        fetchedPerson.setAddress(new Address().setCountry("United Kingdom").setZipcode(55555).setState("Missisipie").setCity("Missisipie"));
        // we don't need to fire update method again as this object is already associated with session so hibernate will automatically update it.
        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}

/*
* @Embeddable: Specifies a class whose instances are stored as an intrinsic part of an owning entity
* */
