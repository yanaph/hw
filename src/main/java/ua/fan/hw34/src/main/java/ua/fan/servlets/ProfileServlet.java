package ua.fan.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", value = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");

        responseBody.println("<h1 align=\"center\">PERSONAL INFO</h1>");

        String ip = req.getRemoteHost();
        String userAgent = req.getHeader("User-Agent");
        responseBody.println(String.format("<h3 align=\"center\"> IP: %s</h3>", ip));
        responseBody.println(String.format("<h3 align=\"center\"> User-Agent: %s</h3>", userAgent));
    }
}
