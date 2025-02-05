package com.xworkz.eventapp.servlet;

import com.xworkz.eventapp.dto.EventDto;
import com.xworkz.eventapp.services.EventServices;
import com.xworkz.eventapp.services.EventServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/addEvent")
public class EventServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uName = req.getParameter("uName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String eventType = req.getParameter("eventType");
        EventDto eventDto = new EventDto();
        eventDto.setUName(uName);
        eventDto.setDob(dob);
        eventDto.setEmail(email);
        eventDto.setAddress(address);
        eventDto.setEventType(eventType);
        EventServices eventServices = new EventServicesImpl();
        eventServices.validAndSave(eventDto);

        req.setAttribute("fname", uName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("First Name : "+uName+"\n");
//        printWriter.write("Date of Birth : "+dob+"\n");
//        printWriter.write("Email ID : "+email+"\n");
//        printWriter.write("Address : "+address+"\n");
//        printWriter.write("Event Type : "+eventType+"\n");
