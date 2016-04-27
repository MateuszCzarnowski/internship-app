package com.example.internship.domain;

import java.util.Date;

public class Investment {
    private int id;
    private Date date;
    private double value;

    public Investment(){}

    public Investment(int id, Date date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
