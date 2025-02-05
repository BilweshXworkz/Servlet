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
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetBookTableServlet extends HttpServlet {
    BookTableServices bookTableServices = new BookTableServicesImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookTableDto> bookTable = bookTableServices.getBook();

        req.setAttribute("booking", bookTable);
        RequestDispatcher requestDispatcher =req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
