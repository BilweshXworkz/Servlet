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
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetOrderDetailsServlet extends HttpServlet {
    RoomOrderServices roomOrderServices = new RoomOrderServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoomOrderDto> roomOrderDtos = roomOrderServices.getRoom();
        req.setAttribute("order", roomOrderDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
