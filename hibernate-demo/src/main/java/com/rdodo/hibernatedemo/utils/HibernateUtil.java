package com.rdodo.hibernatedemo.utils;

import com.rdodo.hibernatedemo.model.Customer;
import com.rdodo.hibernatedemo.model.Employee;
import com.rdodo.hibernatedemo.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Customer.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
