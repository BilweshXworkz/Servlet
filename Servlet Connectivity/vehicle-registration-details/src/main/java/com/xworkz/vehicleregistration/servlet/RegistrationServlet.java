package com.xworkz.vehicleregistration.servlet;

import com.xworkz.vehicleregistration.dto.RegistrationDto;
import com.xworkz.vehicleregistration.services.RegistrationServices;
import com.xworkz.vehicleregistration.services.RegistrationServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/submit")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String vehicleName = req.getParameter("vehicleName");
        String vehicleType = req.getParameter("vehicleType");
        String code = req.getParameter("code");

        RegistrationDto dto = new RegistrationDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailId(emailId);
        dto.setVehicleName(vehicleName);
        dto.setVehicleType(vehicleType);
        dto.setCode(Integer.parseInt(code));

        RegistrationServices registrationServices = new RegistrationServicesImpl();
        registrationServices.validAndSave(dto);

        req.setAttribute("fname", firstName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
