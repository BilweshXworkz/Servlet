package com.xworkz.trainapp.servlet;

import com.xworkz.trainapp.dto.TrainBookingDto;
import com.xworkz.trainapp.services.TrainBookingServices;
import com.xworkz.trainapp.services.TrainBookingServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/booking")
public class GetTrainBookingServlet extends HttpServlet {
    TrainBookingServices trainBookingServices = new TrainBookingServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrainBookingDto> Booking = trainBookingServices.getTrain();
        req.setAttribute("booking", Booking);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
