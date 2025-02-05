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

@WebServlet (urlPatterns = "/book")
public class TravelBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        String start = req.getParameter("start");
        String traveling = req.getParameter("traveling");
        String vehicle = req.getParameter("vehicle");
        TravelBookingDto dto = new TravelBookingDto();
        dto.setFirstName(firstName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setStart(start);
        dto.setTraveling(traveling);
        dto.setVehicle(vehicle);
        TravelBookingServices travelBookingServices = new TravelBookingServicesImpl();
        travelBookingServices.validAndSave(dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
