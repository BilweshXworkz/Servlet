package com.xworkz.bankingapp.servlet;

import com.xworkz.bankingapp.dto.DepositoryDto;
import com.xworkz.bankingapp.services.DepositoryServices;
import com.xworkz.bankingapp.services.DepositoryServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/ok")
public class DepositoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String acNumber = req.getParameter("acNumber");
        String depository = req.getParameter("depository");

        DepositoryDto dto = new DepositoryDto();
        dto.setFullName(fullName);
        dto.setDob(dob);
        dto.setEmailId(email);
        dto.setAcNumber(Long.parseLong(acNumber));
        dto.setDepository(Integer.parseInt(depository));

        DepositoryServices depositoryServices = new DepositoryServicesImpl();
        depositoryServices.validAndSave(dto);

        req.setAttribute("fname", fullName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
