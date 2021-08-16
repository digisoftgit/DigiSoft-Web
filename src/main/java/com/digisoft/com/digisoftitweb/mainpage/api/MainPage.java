package com.digisoft.com.digisoftitweb.mainpage.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


public interface MainPage {

    @GetMapping("/")
    ModelAndView startApp();
}
