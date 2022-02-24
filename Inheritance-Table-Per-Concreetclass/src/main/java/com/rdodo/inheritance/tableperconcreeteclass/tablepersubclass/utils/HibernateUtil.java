package com.rdodo.inheritance.tableperconcreeteclass.tablepersubclass.utils;

import com.rdodo.inheritance.tableperconcreeteclass.tablepersubclass.models.CardPayment;
import com.rdodo.inheritance.tableperconcreeteclass.tablepersubclass.models.ChequePayment;
import com.rdodo.inheritance.tableperconcreeteclass.tablepersubclass.models.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(CardPayment.class)
                .addAnnotatedClass(ChequePayment.class);
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
