package com.xworkz.passport.servlet;

import com.xworkz.passport.dto.RegisterDto;
import com.xworkz.passport.services.RegisterServices;
import com.xworkz.passport.services.RegisterServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/update")
public class updateProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        RegisterDto dto = new RegisterDto();
        dto.setFName(fName);
        dto.setLName(lName);
        dto.setDob(dob);
        dto.setEmail(email);
        dto.setAddress(address);
        RegisterServices registerServices = new RegisterServicesImpl();
        registerServices.validAndSave(dto);
        req.setAttribute("Message", "Updated Successfully");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req, resp);
    }
}
