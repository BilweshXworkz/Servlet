package com.xworkz.feedbackapp.servlet;

import com.xworkz.feedbackapp.dto.FeedbackDto;
import com.xworkz.feedbackapp.entity.FeedbackEntity;
import com.xworkz.feedbackapp.repository.FeedbackRepository;
import com.xworkz.feedbackapp.repository.FeedbackRepositoryImpl;
import com.xworkz.feedbackapp.services.FeedbackServices;
import com.xworkz.feedbackapp.services.FeedbackServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/submit")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String education = req.getParameter("education");
        FeedbackDto dto = new FeedbackDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailId(emailId);
        dto.setEducation(education);
        FeedbackServices feedbackServices = new FeedbackServicesImpl();
        feedbackServices.ValidAndSave(dto);
        req.setAttribute("fname", firstName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
