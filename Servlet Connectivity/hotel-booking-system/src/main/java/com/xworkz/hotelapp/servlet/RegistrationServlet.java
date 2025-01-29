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

@WebServlet (urlPatterns = "/submit")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        String hotel = req.getParameter("hotel");
        String stayTime = req.getParameter("stayTime");
        String numberRoom = req.getParameter("numberRoom");

        RoomOrderDto dto = new RoomOrderDto();
        dto.setFirstName(firstName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setHotel(hotel);
        dto.setStayTime(stayTime);
        dto.setNumberRoom(numberRoom);

        RoomOrderServices roomOrderServices = new RoomOrderServicesImpl();
        roomOrderServices.validAndSave(dto);

        req.setAttribute("fname", firstName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
