package com.zxr.web;

import com.zxr.config.SpringConfig;
import com.zxr.domain.Contact;
import com.zxr.service.ContactService;
import com.zxr.service.impl.ContactServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    //回显
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ContactService contactService = context.getBean("contactService", ContactService.class);
        String id = request.getParameter("id");
        Contact c= contactService.getContact(id);
        request.setAttribute("contact",c);
        System.out.println(c);
        int i=1;
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
