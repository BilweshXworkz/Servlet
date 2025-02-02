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
import java.util.List;

@WebServlet (urlPatterns = "/donation")
public class GetDonationServlet extends HttpServlet {
    DonationServices donationServices = new DonationServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DonationDto> donationDtos = donationServices.getDonation();
        req.setAttribute("donation", donationDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
