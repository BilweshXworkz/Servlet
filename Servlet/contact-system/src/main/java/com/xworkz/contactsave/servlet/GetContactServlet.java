package com.xworkz.contactsave.servlet;

import com.xworkz.contactsave.dto.ContactDto;
import com.xworkz.contactsave.services.ContactServices;
import com.xworkz.contactsave.services.ContactServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetContactServlet extends HttpServlet {
    ContactServices contactServices = new ContactServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ContactDto> contactDtoList = contactServices.getContact();
        req.setAttribute("contact", contactDtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
