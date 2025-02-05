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

@WebServlet (urlPatterns = "/submit")
public class RegisterServlet extends HttpServlet {
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
        req.setAttribute("fname", fName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);

//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("First Name : "+fName+"\n");
//        printWriter.write("Last Name : "+lName+"\n");
//        printWriter.write("Date of Birth : "+dob+"\n");
//        printWriter.write("Email ID : "+email+"\n");
//        printWriter.write("Address : "+address+"\n");
    }
}
