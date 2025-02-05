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
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetRegisterServlet extends HttpServlet {
    RegisterServices registerServices = new RegisterServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RegisterDto> registerDtoList = registerServices.getRegister();
        req.setAttribute("register", registerDtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req,resp);
    }
}
