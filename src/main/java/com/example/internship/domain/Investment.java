package com.example.internship.domain;

import java.util.Date;

public class Investment {
    private int investmentId;
    private Date investmentDate;
    private double investmentValue;

    public Investment(){};

    public Investment(int id, Date date, double value) {
        this.investmentId = id;
        this.investmentDate = date;
        this.investmentValue = value;
    }

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
    }

    public double getInvestmentValue() {
        return investmentValue;
    }

    public void setInvestmentValue(double investmentValue) {
        this.investmentValue = investmentValue;
    }


    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
    }
}
