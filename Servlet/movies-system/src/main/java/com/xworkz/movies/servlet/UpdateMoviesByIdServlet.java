package com.xworkz.movies.servlet;

import com.xworkz.movies.dto.MoviesDto;
import com.xworkz.movies.services.MoviesServices;
import com.xworkz.movies.services.MoviesServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateMoviesByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String mName = req.getParameter("mName");
        String hero = req.getParameter("hero");
        String heroin = req.getParameter("heroin");
        MoviesDto dto = new MoviesDto();
        dto.setId(Integer.parseInt(id));
        dto.setMName(mName);
        dto.setHero(hero);
        dto.setHeroin(heroin);
        MoviesServices moviesServices = new MoviesServicesImpl();
        moviesServices.updateProfile(dto);
        req.setAttribute("Message", "Update Successfully");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProfile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
