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

@WebServlet (urlPatterns = "/updateCourse")
public class GetCourseByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        CourseApplicationServices services = new CourseApplicationServicesImpl();
        CourseApplicationDto dto = services.getCourseById(Integer.parseInt(id));
        req.setAttribute("dto", dto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateCoures.jsp");
        requestDispatcher.forward(req,resp);
    }
}
