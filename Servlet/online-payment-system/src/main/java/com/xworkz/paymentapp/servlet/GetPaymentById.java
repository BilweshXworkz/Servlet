package com.xworkz.paymentapp.servlet;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.services.PaymentServices;
import com.xworkz.paymentapp.services.PaymentServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/GetPaymentById")
public class GetPaymentById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        PaymentServices services = new PaymentServicesImpl();
        PaymentDto dto = services.getPaymentById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updatePayment.jsp");
        requestDispatcher.forward(req,resp);
    }
}
