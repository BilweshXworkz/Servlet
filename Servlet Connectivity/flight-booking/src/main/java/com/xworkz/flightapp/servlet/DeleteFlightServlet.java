package com.xworkz.flightapp.servlet;

import com.xworkz.flightapp.services.FlightBookingServices;
import com.xworkz.flightapp.services.FlightBookingServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/delete")
public class DeleteFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        FlightBookingServices flightBookingServices = new FlightBookingServicesImpl();
        flightBookingServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getDetails.jsp");
        dispatcher.forward(req,resp);
    }
}
