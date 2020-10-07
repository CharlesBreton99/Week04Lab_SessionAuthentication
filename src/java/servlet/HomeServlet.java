package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedIn = (User) session.getAttribute("user");
        
        if (session != null && loggedIn != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.invalidate();
        request.setAttribute("message", "You have successfully logged out");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }

}
