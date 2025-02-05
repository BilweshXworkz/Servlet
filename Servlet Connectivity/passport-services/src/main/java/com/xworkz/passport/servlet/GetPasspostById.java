package com.xworkz.passport.servlet;

import com.xworkz.passport.dto.RegisterDto;
import com.xworkz.passport.services.RegisterServices;
import com.xworkz.passport.services.RegisterServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getProfileById")
public class GetPasspostById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        RegisterServices services = new RegisterServicesImpl();
        RegisterDto dto = services.getProfileById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
