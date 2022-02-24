package com.rdodo.inheritance.tablepersubclass;

import com.rdodo.inheritance.tablepersubclass.models.CardPayment;
import com.rdodo.inheritance.tablepersubclass.models.ChequePayment;
import com.rdodo.inheritance.tablepersubclass.models.Payment;
import com.rdodo.inheritance.tablepersubclass.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class MainPayment {
    public static void main(String[] args) {
        CardPayment cardPayment = new CardPayment(LocalDate.now(), 1232, "121313", 23, 2025, 123);
        ChequePayment chequePayment = new ChequePayment(LocalDate.now(), 544, 787, "Bearer");

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        /*session.persist(cardPayment);
        session.persist(chequePayment);*/

        Payment payment = session.get(Payment.class, 1);
        System.out.println(payment.getPaymentDate() + " : " + payment.getPaymentAmount());
        System.out.println(payment.toString());

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
