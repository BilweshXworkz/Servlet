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
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/send")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String toMail = req.getParameter("toEmail");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        EmailDto dto = new EmailDto();
        dto.setToMail(toMail);
        dto.setSubject(subject);
        dto.setContent(content);
        EmailServices emailServices = new EmailServicesImpl();
        emailServices.validAndSave(dto);
        req.setAttribute("fname", toMail);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
