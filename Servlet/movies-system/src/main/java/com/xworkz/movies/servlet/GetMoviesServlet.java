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
import java.util.List;

@WebServlet (urlPatterns = "/details")
public class GetMoviesServlet extends HttpServlet {
    MoviesServices moviesServices = new MoviesServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MoviesDto> moviesDtoList = moviesServices.getMovies();
        req.setAttribute("movies", moviesDtoList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getDetails.jsp");
        requestDispatcher.forward(req, resp);
    }
}
