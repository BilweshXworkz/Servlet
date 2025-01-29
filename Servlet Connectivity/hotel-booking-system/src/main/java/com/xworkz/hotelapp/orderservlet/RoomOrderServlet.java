package com.xworkz.hotelapp.orderservlet;

import com.xworkz.hotelapp.dto.RoomOrderDto;
import com.xworkz.hotelapp.services.RoomOrderServices;
import com.xworkz.hotelapp.services.RoomOrderServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/order")
public class RoomOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        String hotel = req.getParameter("hotel");
        String stay = req.getParameter("stayTime");
        String room = req.getParameter("numberRoom");
        RoomOrderDto dto = new RoomOrderDto();
        dto.setFirstName(firstName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setHotel(hotel);
        dto.setStayTime(stay);
        dto.setNumberRoom(room);
        RoomOrderServices roomOrderServices = new RoomOrderServicesImpl();
        roomOrderServices.validAndSave(dto);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("The hotel is booked : "+firstName);
        printWriter.write("Phone Number  : "+phoneNumber);
        printWriter.write("Hotel Name : "+hotel);
        printWriter.write("Stay : "+stay);
        printWriter.write("Room Number : "+room);
    }
}
