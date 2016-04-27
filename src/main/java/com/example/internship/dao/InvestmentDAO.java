package com.example.internship.dao;

import com.example.internship.domain.Investment;

import java.util.List;

public interface InvestmentDAO {

    public Investment getInvestment(int id);

    public List<Investment> getAllInvestments();
}
