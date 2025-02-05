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

@WebServlet (urlPatterns = "/getProfileById")
public class GetProfileByIdServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet ProfileById Initialization");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        FlightBookingServices services = new FlightBookingServicesImpl();
        FlightBookingDto dto = services.getProfileById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet ProfileById Destroyed");
    }
}
