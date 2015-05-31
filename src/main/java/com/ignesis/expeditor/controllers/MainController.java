package com.ignesis.expeditor.controllers;

import com.ignesis.expeditor.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Kardi on 30.05.2015.
 */

@Controller
@RequestMapping("/*")
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping("public")
    public String publicPage() {
        mainService.isUserValid("", "");
        return "public";
    }

    @RequestMapping("private")
    public String privatePage() {
        mainService.isUserValid("", "");
        return "private";
    }

    @RequestMapping("login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("logout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);

        response.sendRedirect("login");
    }
}
