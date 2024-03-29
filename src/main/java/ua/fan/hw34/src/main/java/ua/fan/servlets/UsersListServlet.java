package ua.fan.servlets;

import ua.fan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UsersListServlet", value = "/UsersListServlet")
public class UsersListServlet extends HttpServlet {
    private static final List<User> USERS = new ArrayList<>();
    private static final User CURRENT_USER = new User();

    @Override
    public void init() {
        System.out.println(getServletName() + "initialized");
        for (int i = 0; i < 2; i++) {
            String userIP = String.format("127.0.0.%d", i + 3);
            User user1 = new User(LocalDateTime.now(), userIP, "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
            USERS.add(user1);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");

        responseBody.println("<h1 align=\"center\">Users information</h1>");

        String userAgent = req.getHeader("User-Agent");

        CURRENT_USER.setDateTime(LocalDateTime.now());
        CURRENT_USER.setUserAgent(userAgent);
        CURRENT_USER.setIp(req.getRemoteHost());
        USERS.add(CURRENT_USER);
        req.setAttribute("usersList", USERS);
        req.setAttribute("currentUser", CURRENT_USER);

        req.getRequestDispatcher("usersList.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
