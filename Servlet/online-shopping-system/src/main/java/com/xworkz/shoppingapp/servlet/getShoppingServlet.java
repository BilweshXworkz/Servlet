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
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class getShoppingServlet extends HttpServlet {
    ShoppingServices shoppingServices = new ShoppingServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShoppingDto> shoppingDtos = shoppingServices.getShopping();
        req.setAttribute("shopping", shoppingDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
