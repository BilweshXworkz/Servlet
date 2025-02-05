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

@WebServlet (urlPatterns = "/getById")
public class GetDepositoryByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        DepositoryServices services = new DepositoryServicesImpl();
        DepositoryDto dto = services.getDepositoryById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateDepository.jsp");
        requestDispatcher.forward(req,resp);
    }
}
