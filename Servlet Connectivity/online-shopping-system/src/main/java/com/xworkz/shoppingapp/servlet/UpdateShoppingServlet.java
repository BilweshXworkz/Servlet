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

@WebServlet(urlPatterns = "/update")
public class UpdateShoppingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String phoneNumber = req.getParameter("phoneNumber");
        String pName = req.getParameter("pName");
        String quantity = req.getParameter("quantity");
        String address = req.getParameter("address");

        ShoppingDto shoppingDto = new ShoppingDto();
        shoppingDto.setId(Integer.parseInt(id));
        shoppingDto.setFirstName(firstName);
        shoppingDto.setPhoneNumber(Long.parseLong(phoneNumber));
        shoppingDto.setPName(pName);
        shoppingDto.setQuantity(quantity);
        shoppingDto.setAddress(address);

        ShoppingServices shoppingServices = new ShoppingServicesImpl();
        shoppingServices.updateShopping(shoppingDto);


        //Request dispatcher
        // servlet channing
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateShopping.jsp");
        requestDispatcher.forward(req,resp);
    }
}
