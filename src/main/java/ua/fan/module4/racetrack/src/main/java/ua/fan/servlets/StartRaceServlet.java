package ua.fan.servlets;

import ua.fan.config.HibernateFactoryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StartRace", value = "/race/start")
public class StartRaceServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        HibernateFactoryUtil.init();



    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
