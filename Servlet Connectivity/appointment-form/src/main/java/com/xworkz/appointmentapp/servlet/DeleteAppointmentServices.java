package com.xworkz.appointmentapp.servlet;

import com.xworkz.appointmentapp.services.AppointmentServices;
import com.xworkz.appointmentapp.services.AppointmentServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteAppointmentServices extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        AppointmentServices appointmentServices = new AppointmentServicesImpl();
        appointmentServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("details");
        dispatcher.forward(req,resp);
    }
}
