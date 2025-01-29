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
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/submit")
public class AppointmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String aDate = req.getParameter("aDate");

        AppointmentDto dto = new AppointmentDto();
        dto.setName(name);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailid(emailId);
        dto.setAdate(aDate);

        AppointmentServices appointmentServices = new AppointmentServicesImpl();
        appointmentServices.valideAndSave(dto);

        req.setAttribute("fname", name);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
