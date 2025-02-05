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

@WebServlet (urlPatterns = "/getProfileById")
public class GetProfileById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        AppointmentServices services = new AppointmentServicesImpl();
        AppointmentDto dto = services.getProfileById(Integer.parseInt(id));
        req.setAttribute("dto",dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
