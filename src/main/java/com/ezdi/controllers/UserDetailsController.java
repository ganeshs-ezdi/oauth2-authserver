package com.ezdi.controllers;

import com.ezdi.beans.Role;
import com.ezdi.beans.User;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by EZDI\ganesh.s on 19/7/16.
 */
@RestController
public class UserDetailsController {
    @RequestMapping(value="/user",produces="application/json")
    public User user(HttpServletRequest request, Principal principal) {
        User user = new User();
        user.setUsername(principal.getName());

        return user;
    }
}
