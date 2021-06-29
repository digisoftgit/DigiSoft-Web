package com.digisoft.com.digisoftitweb.main.controller;

import com.digisoft.com.digisoftitweb.main.api.MainPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController implements MainPage {

    @Override
    public ModelAndView startApp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
