package com.xworkz.flightapp.servlet;

import com.xworkz.flightapp.dto.FlightBookingDto;
import com.xworkz.flightapp.services.FlightBookingServices;
import com.xworkz.flightapp.services.FlightBookingServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/flightDetails")
public class GetFlightServlet extends HttpServlet {
    FlightBookingServices flightBookingServices = new FlightBookingServicesImpl();

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet GetFlight Initialization");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightBookingDto> flightBookingDtos = flightBookingServices.getflight();
        req.setAttribute("flightDto", flightBookingDtos);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet GetFlight Destroyed");
    }
}
