package com.ezdi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by EZDI\ganesh.s on 14/7/16.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String getLoginPage(){
        return "login";
    }
}
