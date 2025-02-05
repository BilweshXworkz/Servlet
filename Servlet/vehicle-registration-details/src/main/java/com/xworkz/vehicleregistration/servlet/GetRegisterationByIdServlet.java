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

@WebServlet (urlPatterns = "/updateById")
public class GetRegisterationByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        RegistrationServices services = new RegistrationServicesImpl();
        RegistrationDto dto = services.getRegistrationById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateRegistration.jsp");
        requestDispatcher.forward(req,resp);
    }
}
