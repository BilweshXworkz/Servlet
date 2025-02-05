package com.xworkz.feedbackapp.servlet;

import com.xworkz.feedbackapp.dto.FeedbackDto;
import com.xworkz.feedbackapp.repository.FeedbackRepository;
import com.xworkz.feedbackapp.services.FeedbackServices;
import com.xworkz.feedbackapp.services.FeedbackServicesImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/updateById")
public class GetByProfileId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        FeedbackServices services = new FeedbackServicesImpl();
        FeedbackDto dto = services.updateById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req, resp);
    }
}
