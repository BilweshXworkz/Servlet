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
import java.util.List;

@WebServlet(urlPatterns = "/details")
public class getCourseApplicationServlet extends HttpServlet {
    CourseApplicationServices courseApplicationServices = new CourseApplicationServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseApplicationDto> courseApplicationDtos = courseApplicationServices.getCourse();
        req.setAttribute("application", courseApplicationDtos);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
