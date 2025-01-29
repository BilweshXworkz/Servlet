package com.xworkz.trainapp.servlet;

import com.xworkz.trainapp.dto.TrainBookingDto;
import com.xworkz.trainapp.services.TrainBookingServices;
import com.xworkz.trainapp.services.TrainBookingServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/bookTrain")
public class TrainBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String TrainNumber = req.getParameter("num");
        TrainBookingDto dto = new TrainBookingDto();
        dto.setFName(fName);
        dto.setLName(lName);
        dto.setDob(dob);
        dto.setEmail(email);
        dto.setNum(Integer.parseInt(TrainNumber));
        TrainBookingServices trainBookingServices = new TrainBookingServicesImpl();
        trainBookingServices.validAndSave(dto);
        req.setAttribute("fname", fName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
