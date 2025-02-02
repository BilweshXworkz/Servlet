package com.xworkz.eventapp.servlet;

import com.xworkz.eventapp.services.EventServices;
import com.xworkz.eventapp.services.EventServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        EventServices eventServices = new EventServicesImpl();
        eventServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("event");
        dispatcher.forward(req,resp);
    }
}
