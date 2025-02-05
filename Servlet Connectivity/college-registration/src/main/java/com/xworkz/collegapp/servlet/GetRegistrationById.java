package com.xworkz.collegapp.servlet;

import com.xworkz.collegapp.dto.CollegeApplicationDto;
import com.xworkz.collegapp.services.CollegeApplicationServices;
import com.xworkz.collegapp.services.CollegeApplicationServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/getprofileById")
public class GetRegistrationById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        CollegeApplicationServices services = new CollegeApplicationServicesImpl();
        CollegeApplicationDto dto = services.getProfileById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req, resp);
    }
}
