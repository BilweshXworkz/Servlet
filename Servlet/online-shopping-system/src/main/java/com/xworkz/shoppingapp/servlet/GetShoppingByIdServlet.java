package com.xworkz.shoppingapp.servlet;

import com.xworkz.shoppingapp.dto.ShoppingDto;
import com.xworkz.shoppingapp.services.ShoppingServices;
import com.xworkz.shoppingapp.services.ShoppingServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/updateShopping")
public class GetShoppingByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        ShoppingServices services = new ShoppingServicesImpl();
        ShoppingDto dto = services.getShoppingById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateShopping.jsp");
        requestDispatcher.forward(req,resp);
    }
}
