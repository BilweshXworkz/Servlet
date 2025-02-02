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
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetFeedbackServlet extends HttpServlet {
    FeedbackServices feedbackServices = new FeedbackServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FeedbackDto> feedbackDtos = feedbackServices.getFeedback();
        req.setAttribute("feedback", feedbackDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
