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

@WebServlet (urlPatterns = "/update")
public class UpdateDonationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String pNumber = req.getParameter("phoneNumber");
        String dAmount = req.getParameter("dAmount");
        String payment = req.getParameter("payment");

        DonationDto dto = new DonationDto();
        dto.setId(Integer.parseInt(id));
        dto.setName(name);
        dto.setPhoneNumber(Long.parseLong(pNumber));
        dto.setDAmount(Integer.parseInt(dAmount));
        dto.setPayment(Integer.parseInt(payment));

        DonationServices donationServices = new DonationServicesImpl();
        donationServices.updateDonation(dto);

        req.setAttribute("updateMsg", "Updated Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateDonation.jsp");
        requestDispatcher.forward(req,resp);
    }
}
