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
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetPaymentServlet extends HttpServlet {
    PaymentServices paymentServices = new PaymentServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PaymentDto> paymentDtoList = paymentServices.getPayment();
        req.setAttribute("payment", paymentDtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
