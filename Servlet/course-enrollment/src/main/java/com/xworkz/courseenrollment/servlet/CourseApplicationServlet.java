package com.xworkz.courseenrollment.servlet;

import com.xworkz.courseenrollment.dto.CourseApplicationDto;
import com.xworkz.courseenrollment.services.CourseApplicationServices;
import com.xworkz.courseenrollment.services.CourseApplicationServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/apply")
public class CourseApplicationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String emailId = req.getParameter("emailId");
        String education = req.getParameter("education");
        CourseApplicationDto dto = new CourseApplicationDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setPhoneNumber(Long.parseLong(phoneNumber));
        dto.setEmailId(emailId);
        dto.setEducation(education);
        CourseApplicationServices courseApplicationServices = new CourseApplicationServicesImpl();
        courseApplicationServices.ValidAndSave(dto);
        req.setAttribute("fname", firstName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
