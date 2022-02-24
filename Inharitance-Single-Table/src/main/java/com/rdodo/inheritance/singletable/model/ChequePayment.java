package com.rdodo.inheritance.singletable.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("cheque")
public class ChequePayment extends Payment{
    private int chequeNo;
    private  String chequeType;

    public ChequePayment() {
        super();
    }

    public ChequePayment(LocalDate localDate, int payemntAmount, int chequeNo, String chequeType) {
        super(localDate, payemntAmount);
        this.chequeNo = chequeNo;
        this.chequeType = chequeType;
    }

    public int getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(int chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getChequeType() {
        return chequeType;
    }

    public void setChequeType(String chequeType) {
        this.chequeType = chequeType;
    }

    @Override
    public String toString() {
        return "ChequePayment{" +
                "chequeNo=" + chequeNo +
                ", chequeType='" + chequeType + '\'' +
                '}';
    }
}
