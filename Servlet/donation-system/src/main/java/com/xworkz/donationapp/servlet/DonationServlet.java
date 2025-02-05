package com.xworkz.donationapp.servlet;

import com.xworkz.donationapp.dto.DonationDto;
import com.xworkz.donationapp.services.DonationServices;
import com.xworkz.donationapp.services.DonationServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/donate")
public class DonationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pNumber = req.getParameter("phoneNumber");
        String dAmount = req.getParameter("dAmount");
        String payment = req.getParameter("payment");
        DonationDto dto = new DonationDto();
        dto.setName(name);
        dto.setPhoneNumber(Long.parseLong(pNumber));
        dto.setDAmount(Integer.parseInt(dAmount));
        dto.setPayment(Integer.parseInt(payment));
        DonationServices donationServices = new DonationServicesImpl();
        donationServices.ValidAndSave(dto);

        req.setAttribute("fname", name);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
