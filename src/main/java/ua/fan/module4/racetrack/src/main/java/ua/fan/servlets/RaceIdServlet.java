package ua.fan.servlets;

import ua.fan.dao.RaceDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "RaceIdServlet", value = "raceId")
public class RaceIdServlet extends HttpServlet {
    private static final RaceDao RACE_DAO = new RaceDao();

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        LocalDate date = RACE_DAO.getById(id).getDate();
        Integer distance = RACE_DAO.getById(id).getTotalDistance();
        Integer racers = RACE_DAO.getById(id).getNumOfRacers();
        Integer betHorseNumber = RACE_DAO.getById(id).getBetHorseNumber();
        Integer betHorsePlace = (Integer) RACE_DAO.getBetHorsePlace(id);
         try {
            writer.println("<p>ID: " + id + "</p>");
            writer.println("<p>Race date: " + date + "</p>");
            writer.println("<p>Distance: " + distance + "</p>");
            writer.println("<p>Quantity of horses: " + racers + "</p>");
            writer.println("<p>Bet horse number: " + betHorseNumber + "</p>");
            writer.println("<p>Bet horse place: " + betHorsePlace + "</p>");
        } finally {
            writer.close();
        }
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
