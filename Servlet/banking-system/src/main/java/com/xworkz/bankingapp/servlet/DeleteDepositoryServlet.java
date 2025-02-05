package com.xworkz.bankingapp.servlet;

import com.xworkz.bankingapp.services.DepositoryServices;
import com.xworkz.bankingapp.services.DepositoryServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteDepositoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        DepositoryServices depositoryServices = new DepositoryServicesImpl();
        depositoryServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("depositoryDetails");
        dispatcher.forward(req,resp);
    }
}
