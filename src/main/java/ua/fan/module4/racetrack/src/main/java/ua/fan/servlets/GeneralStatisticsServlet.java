package ua.fan.servlets;

import ua.fan.dao.RaceDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "GeneralStatistics", urlPatterns = "/stats")
public class GeneralStatisticsServlet extends HttpServlet {
    private static final RaceDao RACE_DAO = new RaceDao();

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.println("<h1 align=\"center\">GENERAL INFORMATION</h1>");
        int countRaces = RACE_DAO.getCountOfRaces();
        List<Object[]> betHorsePlaces = RACE_DAO.getBetHorsePlaces();

        writer.println("<h2 align=\"center\">Total number of races: " + countRaces + "</h2>");
        writer.println("<h2 align=\"center\">Bet horse places (race_id, place): </h2>");
        writer.println("<table> " +
                "<tr>" +
                "<th>Race_id</th>" +
                "<th>Place</th>" +
                "</tr>");

        for (Object[] objects : betHorsePlaces) {
            writer.println("<tr>" +
                    "<td>" + objects[0] + "</td>" +
                    "<td>" + objects[1] + "</td>" +
                    "</tr");
        }
        writer.println("</table>");

    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
