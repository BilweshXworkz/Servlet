package com.xworkz.jobapp.servlet;

import com.xworkz.jobapp.dto.JobApplydto;
import com.xworkz.jobapp.services.JobApplyServices;
import com.xworkz.jobapp.services.JobApplyServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/update")
public class UpdateJobApplyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
        String firstName =req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String jobApplying = req.getParameter("jobApplying");
        JobApplydto jobApplydto = new JobApplydto();
        jobApplydto.setId(Integer.parseInt(id));
        jobApplydto.setFirstName(firstName);
        jobApplydto.setLastName(lastName);
        jobApplydto.setPhoneNumber(Long.parseLong(phoneNumber));
        jobApplydto.setEmailId(emailId);
        JobApplyServices jobApplyServices = new JobApplyServicesImpl();
        jobApplyServices.updateApplication(jobApplydto);
        jobApplydto.setJobApplying(jobApplying);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateApplication.jsp");
        requestDispatcher.forward(req,resp);
    }
}
