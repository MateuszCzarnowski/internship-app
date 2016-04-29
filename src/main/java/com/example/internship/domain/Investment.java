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


    public void setDate(Date date) {
        this.date = date;
    }


    public void setValue(double value) {
        this.value = value;
    }


    public void setId(int id) {
        this.id = id;
    }
}
