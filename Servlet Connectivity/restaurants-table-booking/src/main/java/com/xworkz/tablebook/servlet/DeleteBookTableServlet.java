package com.xworkz.tablebook.servlet;

import com.xworkz.tablebook.services.BookTableServices;
import com.xworkz.tablebook.services.BookTableServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteBookTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        BookTableServices bookTableServices = new BookTableServicesImpl();
        bookTableServices.deleteById(Integer.parseInt(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getDetails.jsp");
        dispatcher.forward(req,resp);
    }
}
