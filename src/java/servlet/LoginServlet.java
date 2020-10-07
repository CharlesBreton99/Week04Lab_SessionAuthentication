package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        User loggedIn = (User) session.getAttribute("user");
        if (session != null && loggedIn != null) {
           response.sendRedirect("/Week04Lab_SessionAuthentication/home");
        } else {
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
       

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService check = new AccountService();
        User login;

        login = check.login(username, password);
        if (login != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", login);
            //getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            response.sendRedirect("/Week04Lab_SessionAuthentication/home");

        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Invalid login. Please try again");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }
    }

}
