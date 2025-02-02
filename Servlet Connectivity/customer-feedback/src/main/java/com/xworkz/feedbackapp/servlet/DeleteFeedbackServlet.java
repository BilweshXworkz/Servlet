package com.xworkz.feedbackapp.servlet;

import com.xworkz.feedbackapp.services.FeedbackServices;
import com.xworkz.feedbackapp.services.FeedbackServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteFeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        FeedbackServices feedbackServices = new FeedbackServicesImpl();
        feedbackServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getDetails.jsp");
        dispatcher.forward(req,resp);
    }
}
