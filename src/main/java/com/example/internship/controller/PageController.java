package com.example.internship.controller;

import com.example.internship.dao.InvestmentDAO;
import com.example.internship.domain.Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private InvestmentDAO investmentDAO;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView model) {
//        model.addObject("data", "test");
        List<Investment> investments = investmentDAO.getAllInvestments();
        model.addObject("investmentList", investments);
        model.setViewName("index");

        return model;
    }

    @RequestMapping("/compare")
    public String compare() {
        return "compare";
    }

}
