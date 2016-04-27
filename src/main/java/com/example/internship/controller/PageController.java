package com.example.internship.controller;

import com.example.internship.dao.InvestmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @Autowired
    private InvestmentDAO investmentDAO;

    @RequestMapping("/")
    public ModelAndView index() {

        return new ModelAndView("index", "data", "test");
    }

    @RequestMapping("/compare")
    public String compare() {
        return "compare";
    }

}
