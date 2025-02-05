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

@WebServlet (urlPatterns = "/update")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Update Initialization");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Setvlet Started");
        String id = req.getParameter("id");
        String fName = req.getParameter("fName");
        String from = req.getParameter("from");
        String departure= req.getParameter("departure");
        String returns = req.getParameter("returns");
        String num = req.getParameter("num");

        FlightBookingDto dto = new FlightBookingDto();
        dto.setId(Integer.parseInt(id));
        dto.setFirstName(fName);
        dto.setFrom(from);
        dto.setDeparture(departure);
        dto.setReturns(returns);
        dto.setNumber(Integer.parseInt(num));

        FlightBookingServices flightServices = new FlightBookingServicesImpl();
        flightServices.updateProfileById(dto);

        req.setAttribute("Message","Updated Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Update Destroyed");
    }
}
