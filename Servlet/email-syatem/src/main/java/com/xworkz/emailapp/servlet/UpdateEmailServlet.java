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

@WebServlet (urlPatterns = "/update")
public class UpdateEmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String toMail = req.getParameter("toEmail");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        EmailDto dto = new EmailDto();
        dto.setId(Integer.parseInt(id));
        dto.setToMail(toMail);
        dto.setSubject(subject);
        dto.setContent(content);
        EmailServices emailServices = new EmailServicesImpl();
        emailServices.updateMail(dto);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateMail.jsp");
        requestDispatcher.forward(req,resp);
    }
}
