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
import java.util.List;

@WebServlet(urlPatterns = "/details")
public class GetRegistrationDetails extends HttpServlet {
    RegistrationServices registrationServices = new RegistrationServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RegistrationDto> registrationDtoList = registrationServices.getRegistration();

        req.setAttribute("registration" , registrationDtoList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req,resp);
    }
}
