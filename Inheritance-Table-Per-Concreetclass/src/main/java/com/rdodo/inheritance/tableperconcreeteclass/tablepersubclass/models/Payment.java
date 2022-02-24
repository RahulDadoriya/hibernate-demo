package com.rdodo.inheritance.tableperconcreeteclass.tablepersubclass.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "payment_id")
    private int id;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @Column(name = "payment_amount")
    private int paymentAmount;

    public Payment() {
    }

    public Payment(LocalDate paymentDate, int paymentAmount) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
