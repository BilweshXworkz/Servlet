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

@WebServlet(urlPatterns = "/GetDonationById")
public class GetDonationByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        DonationServices services = new DonationServicesImpl();
        DonationDto dto = services.getDonationById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateDonation.jsp");
        requestDispatcher.forward(req,resp);
    }
}
