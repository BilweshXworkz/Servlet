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
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/submit")
public class CollegeRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String education = req.getParameter("education");
        CollegeApplicationDto dto = new CollegeApplicationDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailId(emailId);
        dto.setEducation(education);
        CollegeApplicationServices collegeApplicationServices = new CollegeApplicationServicesImpl();
        collegeApplicationServices.ValidAndSave(dto);
        req.setAttribute("fname", firstName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
