package com.xworkz.vehicleregistration.servlet;

import com.xworkz.vehicleregistration.services.RegistrationServices;
import com.xworkz.vehicleregistration.services.RegistrationServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        RegistrationServices registrationServices = new RegistrationServicesImpl();
        registrationServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getDetails.jsp");
        dispatcher.forward(req,resp);

    }
}
