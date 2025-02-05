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
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/pay")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        String ifsCode = req.getParameter("ifsCode");
        String account = req.getParameter("account");
        String amount = req.getParameter("amount");
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setFirstName(firstName);
        paymentDto.setPhoneNumber(Long.parseLong(phoneNumber));
        paymentDto.setIfsCode(ifsCode);
        paymentDto.setAccount(Long.parseLong(account));
        paymentDto.setAmount(Integer.parseInt(amount));
        PaymentServices paymentServices = new PaymentServicesImpl();
        paymentServices.validAndSave(paymentDto);
        req.setAttribute("fname", firstName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
