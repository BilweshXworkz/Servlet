package com.xworkz.appointmentapp.servlet;

import com.xworkz.appointmentapp.dto.AppointmentDto;
import com.xworkz.appointmentapp.services.AppointmentServices;
import com.xworkz.appointmentapp.services.AppointmentServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetAppointmentServlet extends HttpServlet {
    AppointmentServices appointmentServices = new AppointmentServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AppointmentDto> appointments = appointmentServices.getAppointment();
        req.setAttribute("appointment", appointments);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req,resp);
    }
}