package com.xworkz.hotelapp.servlet;

import com.xworkz.hotelapp.services.RoomOrderServices;
import com.xworkz.hotelapp.services.RoomOrderServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        RoomOrderServices roomOrderServices = new RoomOrderServicesImpl();
        roomOrderServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("details");
        dispatcher.forward(req,resp);
    }
}
