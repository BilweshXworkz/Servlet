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

@WebServlet(urlPatterns = "/updateEmail")
public class GetEmailByID extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        EmailServices services = new EmailServicesImpl();
        EmailDto dto = services.getEmailByProfile(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateMail.jsp");
        requestDispatcher.forward(req, resp);
    }
}
