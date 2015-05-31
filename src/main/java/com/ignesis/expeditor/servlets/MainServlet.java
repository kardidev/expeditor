package com.ignesis.expeditor.servlets;

import com.ignesis.expeditor.beans.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kardi on 30.05.2015.
 */

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        SimpleBean bean = context.getBean(SimpleBean.class);
        System.out.println("Bean: " + bean);

        PrintWriter writer = null;
        try {
            response.setHeader("content-type", "text/html");
            writer = response.getWriter();
            writer.println("<html><body>Helloooooooooo broooo!!!</body></html>");
        } catch (IOException e) {

        } finally {
            if (writer != null) writer.close();
        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(this + " >> initialized");
    }

}
