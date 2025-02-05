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

@WebServlet(urlPatterns = "/apply", loadOnStartup = +1)
public class FlightServlet extends HttpServlet {

    public FlightServlet(){
        System.out.println("Adding Profile Details");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Servlet Started");
        String fName = req.getParameter("fName");
        String from = req.getParameter("from");
        String departure= req.getParameter("departure");
        String returns = req.getParameter("returns");
        String num = req.getParameter("num");

        FlightBookingDto dto = new FlightBookingDto();
        dto.setFirstName(fName);
        dto.setFrom(from);
        dto.setDeparture(departure);
        dto.setReturns(returns);
        dto.setNumber(Integer.parseInt(num));

        FlightBookingServices flightBookingServices = new FlightBookingServicesImpl();
        flightBookingServices.valideAndSave(dto);
        req.setAttribute("fname", fName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
        System.out.println("Servlet Ended");
    }
}
