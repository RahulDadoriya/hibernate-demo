package com.rdodo.inheritance.singletable;

import com.rdodo.inheritance.singletable.model.CardPayment;
import com.rdodo.inheritance.singletable.model.ChequePayment;
import com.rdodo.inheritance.singletable.model.Payment;
import com.rdodo.inheritance.singletable.util.HibernateUtil;
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

        Payment payment = session.get(Payment.class, 2);
        if (payment instanceof CardPayment) {
            CardPayment cardPayment1 = (CardPayment) payment;
            System.out.println("Card Payment: " + cardPayment1.getPaymentDate() + " : " + cardPayment1.getPaymentAmount());
            System.out.println(cardPayment1.toString());
        } else {
            ChequePayment chequePayment1 = (ChequePayment) payment;
            System.out.println("Cheque Payment: " + chequePayment1.getPaymentDate() + " : " + chequePayment1.getPaymentAmount());
            System.out.println(chequePayment1.toString());
        }

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
