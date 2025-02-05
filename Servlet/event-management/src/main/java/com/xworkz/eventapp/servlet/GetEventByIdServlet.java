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

@WebServlet (urlPatterns = "/GetEventById")
public class GetEventByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        EventServices services = new EventServicesImpl();
        EventDto dto = services.getDonationById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateEvent.jsp");
        requestDispatcher.forward(req,resp);
    }
}
