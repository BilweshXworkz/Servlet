package com.xworkz.trainapp.servlet;

import com.xworkz.trainapp.services.TrainBookingServices;
import com.xworkz.trainapp.services.TrainBookingServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/delete")
public class DeleteBookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        TrainBookingServices trainBookingServices = new TrainBookingServicesImpl();
        trainBookingServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("booking");
        dispatcher.forward(req,resp);
    }
}
