package com.rdodo.inheritance.tableperconcreeteclass.tablepersubclass.models;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class CardPayment extends Payment{

    private String cardNo;
    private int validUptoMonth;
    private int validUptoYear;
    private int cvv;

    public CardPayment() {
        super();
    }

    public CardPayment(LocalDate localDate, int payemntAmount, String cardNo, int validUptoMonth, int validUptoYear, int cvv) {
        super(localDate, payemntAmount);
        this.cardNo = cardNo;
        this.validUptoMonth = validUptoMonth;
        this.validUptoYear = validUptoYear;
        this.cvv = cvv;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getValidUptoMonth() {
        return validUptoMonth;
    }

    public void setValidUptoMonth(int validUptoMonth) {
        this.validUptoMonth = validUptoMonth;
    }

    public int getValidUptoYear() {
        return validUptoYear;
    }

    public void setValidUptoYear(int validUptoYear) {
        this.validUptoYear = validUptoYear;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "cardNo='" + cardNo + '\'' +
                ", validUptoMonth=" + validUptoMonth +
                ", validUptoYear=" + validUptoYear +
                ", cvv=" + cvv +
                '}';
    }
}
