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

@WebServlet (urlPatterns = "/updateContact")
public class GetContactByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        ContactServices services = new ContactServicesImpl();
        ContactDto dto = services.getDonationById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateContact.jsp");
        requestDispatcher.forward(req,resp);
    }
}
