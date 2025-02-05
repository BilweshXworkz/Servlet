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

@WebServlet (urlPatterns = "/updateById")
public class GetTravelByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        TravelBookingServices services = new TravelBookingServicesImpl();
        TravelBookingDto dto = services.getBookingById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateBooking.jsp");
        requestDispatcher.forward(req,resp);
    }
}
