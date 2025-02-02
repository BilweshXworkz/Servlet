package com.xworkz.jobapp.servlet;

import com.xworkz.jobapp.services.JobApplyServices;
import com.xworkz.jobapp.services.JobApplyServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet  (urlPatterns = "/delete")
public class DeleteJobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        JobApplyServices jobApplyServices = new JobApplyServicesImpl();
        jobApplyServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getDetails.jsp");
        dispatcher.forward(req,resp);
    }
}
