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
import java.util.List;

@WebServlet (urlPatterns = "/applicationDetails")
public class GetCollegeApplicationServlet extends HttpServlet {
    CollegeApplicationServices collegeApplicationServices = new CollegeApplicationServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CollegeApplicationDto> collegeApplication = collegeApplicationServices.getApplication();

        req.setAttribute("application", collegeApplication);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req,resp);
    }
}
