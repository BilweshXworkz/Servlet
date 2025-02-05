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

@WebServlet (urlPatterns = "/Update")
public class UpdateBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        String hotel = req.getParameter("hotel");
        String stayTime = req.getParameter("stayTime");
        String numberRoom = req.getParameter("numberRoom");

        RoomOrderDto dto = new RoomOrderDto();
        dto.setId(Integer.parseInt(id));
        dto.setFirstName(firstName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setHotel(hotel);
        dto.setStayTime(stayTime);
        dto.setNumberRoom(numberRoom);

        RoomOrderServices roomOrderServices = new RoomOrderServicesImpl();
        roomOrderServices.updateBooking(dto);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateBooking.jsp");
        requestDispatcher.forward(req,resp);
    }
}
