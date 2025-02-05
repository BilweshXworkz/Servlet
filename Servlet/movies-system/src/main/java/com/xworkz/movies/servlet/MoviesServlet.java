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
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/send")
public class MoviesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mName = req.getParameter("mName");
        String hero = req.getParameter("hero");
        String heroin = req.getParameter("heroin");
        MoviesDto dto = new MoviesDto();
        dto.setMName(mName);
        dto.setHero(hero);
        dto.setHeroin(heroin);
        MoviesServices moviesServices = new MoviesServicesImpl();
        moviesServices.validAndSave(dto);
        req.setAttribute("fname", mName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("responses.jsp");
        requestDispatcher.forward(req,resp);
    }
}
