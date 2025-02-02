package com.xworkz.emailapp.servlet;

import com.xworkz.emailapp.services.EmailServices;
import com.xworkz.emailapp.services.EmailServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteEmail")
public class DeleteServlet  extends HttpServlet {
    EmailServices emailServices = new EmailServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String toEmail = req.getParameter("toEmail");
        if (toEmail != null && !toEmail.isEmpty()) {
            emailServices.deleteByToEmail(toEmail);
            System.out.println("Deleted email for: " + toEmail);
        }
        resp.sendRedirect("getDetails.jsp"); // Redirect to updated list
    }
}
