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

@WebServlet (urlPatterns = "/getProfileById")
public class GetProfileByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        TrainBookingServices services = new TrainBookingServicesImpl();
        TrainBookingDto dto = services.getProfileById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
