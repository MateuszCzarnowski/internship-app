package com.example.internship.dao;

import com.example.internship.domain.Investment;

import java.util.List;

public interface InvestmentDAO {

    Investment getInvestment(int id);

    List<Investment> getAllInvestments();

    List<Investment> getInvestmentsByDate(String date1, String date2);
}
