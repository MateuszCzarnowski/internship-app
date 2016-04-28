package com.example.internship.controller;

import com.example.internship.dao.InvestmentDAO;
import com.example.internship.domain.Investment;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private InvestmentDAO investmentDAO;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView model) {
//        model.addObject("data", "test");
        List<Investment> investments = investmentDAO.getInvestmentsByDate("01/01/2015", "01/01/2016");
        model.addObject("investmentList", investments);
        model.setViewName("index");

        return model;
    }

    @RequestMapping("/compare")
    public String compare() {
        return "compare";
    }

    @RequestMapping(value = "/getData/{date1}/{date2}", method = RequestMethod.GET)
    @ResponseBody
    public String sendData(@PathVariable String date1, @PathVariable String date2) {

        List<Investment> investments = investmentDAO.getInvestmentsByDate(date1, date2);

        String json = new Gson().toJson(investments);

        return json;
    }

}
