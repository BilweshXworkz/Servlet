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

@WebServlet (urlPatterns = "/updateApplication")
public class GetApplictionByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        JobApplyServices services = new JobApplyServicesImpl();
        JobApplydto dto = services.getApplyById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateApplication.jsp");
        requestDispatcher.forward(req,resp);
    }
}
