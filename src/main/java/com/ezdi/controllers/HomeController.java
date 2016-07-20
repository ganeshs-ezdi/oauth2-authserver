package com.ezdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by EZDI\ganesh.s on 13/7/16.
 */
@Controller
public class HomeController {

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/")
    public String index(Model model) {
        Object value = httpSession.getAttribute("visited");
        if(value == null){
            value = new Integer(1);
            httpSession.setAttribute("visited", value);
        } else {
            Integer i = (Integer)value;
            i++;
            httpSession.setAttribute("visited", i);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)auth.getAuthorities();
        String name = auth.getName();

        model.addAttribute("name", name);
        model.addAttribute("authorities", authorities);
        model.addAttribute("visited", value);

        return "home";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin")
    public String adminPortal(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)auth.getAuthorities();
        String name = auth.getName();

        model.addAttribute("name", name);
        model.addAttribute("authorities", authorities);

        return "admin";
    }
}
