package com.xworkz.tablebook.servlet;

import com.xworkz.tablebook.dto.BookTableDto;
import com.xworkz.tablebook.services.BookTableServices;
import com.xworkz.tablebook.services.BookTableServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateTableServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String phone = req.getParameter("phoneNumber");
        String  person = req.getParameter("person");
        String  time = req.getParameter("Time");

        BookTableDto dto =new BookTableDto();
        dto.setId(Integer.parseInt(id));
        dto.setFirstName(firstName);
        dto.setPhoneNumber(Long.parseLong(phone));
        dto.setPerson(person);
        dto.setTime(time);

        BookTableServices bookTableServices = new BookTableServicesImpl();
        bookTableServices.updateTable(dto);

        req.setAttribute("updateMsg", "Updated Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
