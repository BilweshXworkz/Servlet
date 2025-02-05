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

@WebServlet (urlPatterns = "/updateTableId")
public class GetTableById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        BookTableServices services = new BookTableServicesImpl();
        BookTableDto dto = services.getTableById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateTable.jsp");
        requestDispatcher.forward(req,resp);
    }
}
