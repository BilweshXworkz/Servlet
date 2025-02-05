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

@WebServlet (urlPatterns = "/update")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String aDate = req.getParameter("aDate");

        AppointmentDto dto = new AppointmentDto();
        dto.setId(Integer.parseInt(id));
        dto.setName(name);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailid(emailId);
        dto.setAdate(aDate);

        AppointmentServices appointmentServices = new AppointmentServicesImpl();
        appointmentServices.UpdateProfile(dto);

        req.setAttribute("UpdateMsg", "Update Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
