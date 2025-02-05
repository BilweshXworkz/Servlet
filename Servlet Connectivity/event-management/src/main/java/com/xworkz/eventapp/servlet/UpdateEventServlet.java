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

@WebServlet (urlPatterns = "/update")
public class UpdateEventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String uName = req.getParameter("uName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String eventType = req.getParameter("eventType");
        EventDto eventDto = new EventDto();
        eventDto.setId(Integer.parseInt(id));
        eventDto.setUName(uName);
        eventDto.setDob(dob);
        eventDto.setEmail(email);
        eventDto.setAddress(address);
        eventDto.setEventType(eventType);

        EventServices eventServices = new EventServicesImpl();
        eventServices.updateEvent(eventDto);

        req.setAttribute("updateMsg", "Updated Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateEvent.jsp");
        requestDispatcher.forward(req,resp);
    }
}
