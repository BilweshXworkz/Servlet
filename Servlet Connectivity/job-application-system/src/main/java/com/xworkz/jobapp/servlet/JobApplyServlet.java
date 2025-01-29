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
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/apply")
public class JobApplyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName =req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String jobApplying = req.getParameter("jobApplying");
        JobApplydto jobApplydto = new JobApplydto();
        jobApplydto.setFirstName(firstName);
        jobApplydto.setLastName(lastName);
        jobApplydto.setPhoneNumber(Long.parseLong(phoneNumber));
        jobApplydto.setEmailId(emailId);
        JobApplyServices jobApplyServices = new JobApplyServicesImpl();
        jobApplyServices.ValidAndSave(jobApplydto);
        jobApplydto.setJobApplying(jobApplying);

        req.setAttribute("fname", firstName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
//        PrintWriter printWriter =resp.getWriter();
//        printWriter.write("Thank you " +firstName+" Applying for job");
    }
}
