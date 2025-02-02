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
import java.util.List;

@WebServlet (urlPatterns = "/depositoryDetails")
public class GetDepositoryServlet extends HttpServlet {
    DepositoryServices depositoryServices = new DepositoryServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DepositoryDto> depository = depositoryServices.GetDepository();
        req.setAttribute("bankDetail", depository);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req,resp);
    }
}
