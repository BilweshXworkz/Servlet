package com.xworkz.emailapp.servlet;

import com.xworkz.emailapp.dto.EmailDto;
import com.xworkz.emailapp.services.EmailServices;
import com.xworkz.emailapp.services.EmailServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetEmailDetails extends HttpServlet {
    EmailServices emailServices = new EmailServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EmailDto> emailDtoList = emailServices.getEmail();
        req.setAttribute("email", emailDtoList);

        RequestDispatcher requestDispatcher =req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req,resp);
    }
}
