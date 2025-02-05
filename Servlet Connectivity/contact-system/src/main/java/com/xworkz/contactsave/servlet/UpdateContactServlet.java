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

@WebServlet (urlPatterns = "/update")
public class UpdateContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("emailId");
        String description = req.getParameter("description");

        ContactDto dto = new ContactDto();
        dto.setId(Integer.parseInt(id));
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailId(email);
        dto.setDescription(description);
        ContactServices contactServices = new ContactServicesImpl();
        contactServices.updateContact(dto);

        req.setAttribute("updateMsg", "Updated Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateContact.jsp");
        requestDispatcher.forward(req,resp);
    }
}
