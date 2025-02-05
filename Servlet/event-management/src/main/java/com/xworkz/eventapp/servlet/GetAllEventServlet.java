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
import java.util.List;

@WebServlet (urlPatterns = "/event")
public class GetAllEventServlet extends HttpServlet {
    EventServices eventServices = new EventServicesImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EventDto> event = eventServices.getEvent();
        req.setAttribute("event", event);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
