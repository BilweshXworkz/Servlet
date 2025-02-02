package com.xworkz.travelapp.servlet;

import com.xworkz.travelapp.dto.TravelBookingDto;
import com.xworkz.travelapp.services.TravelBookingServices;
import com.xworkz.travelapp.services.TravelBookingServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/booking")
public class GetBookingDetails extends HttpServlet {
    TravelBookingServices travelBookingServices = new TravelBookingServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TravelBookingDto> travelBookingDtos = travelBookingServices.getBooking();
        req.setAttribute("booking", travelBookingDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
