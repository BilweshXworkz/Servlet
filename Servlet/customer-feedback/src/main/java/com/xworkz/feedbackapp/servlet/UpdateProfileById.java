package com.xworkz.feedbackapp.servlet;

import com.xworkz.feedbackapp.dto.FeedbackDto;
import com.xworkz.feedbackapp.services.FeedbackServices;
import com.xworkz.feedbackapp.services.FeedbackServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateProfileById extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String education = req.getParameter("education");
        FeedbackDto dto = new FeedbackDto();

        dto.setId(Integer.parseInt(id));
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailId(emailId);
        dto.setEducation(education);

        FeedbackServices feedbackServices = new FeedbackServicesImpl();
        feedbackServices.updateProfile(dto);
        req.setAttribute("UpdateMsg", "Update Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
