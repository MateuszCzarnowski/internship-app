package com.example.internship.dao;

import com.example.internship.domain.Investment;

import java.util.List;

public interface InvestmentDAO {

    List<Investment> getInvestmentsByDate(String date1, String date2);
}
