package com.xworkz.hotelapp.servlet;

import com.xworkz.hotelapp.dto.RoomOrderDto;
import com.xworkz.hotelapp.services.RoomOrderServices;
import com.xworkz.hotelapp.services.RoomOrderServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateByBooking")
public class GetBookingById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        RoomOrderServices services = new RoomOrderServicesImpl();
        RoomOrderDto dto = services.getBookingById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateBooking.jsp");
        requestDispatcher.forward(req,resp);
    }
}
