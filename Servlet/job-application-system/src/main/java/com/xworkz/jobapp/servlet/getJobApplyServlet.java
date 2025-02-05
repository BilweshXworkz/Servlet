package com.xworkz.jobapp.servlet;

import com.xworkz.jobapp.dto.JobApplydto;
import com.xworkz.jobapp.services.JobApplyServices;
import com.xworkz.jobapp.services.JobApplyServicesImpl;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class getJobApplyServlet extends HttpServlet {
    JobApplyServices jobApplyServices = new JobApplyServicesImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JobApplydto> jobApplydtoList = jobApplyServices.getApply();
        req.setAttribute("apply", jobApplydtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
