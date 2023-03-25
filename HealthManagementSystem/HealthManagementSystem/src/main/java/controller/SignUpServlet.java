package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(0, username, password, email);
        UserDAO userDao = new UserDAO();
        boolean isSuccess = userDao.addUser(user);

        if (isSuccess) {
            String message = "User registration successful!";
            request.setAttribute("message", message);
            response.sendRedirect("login.jsp");
        } else {
            String message = "User registration failed.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("sign-up.jsp").forward(request, response);
        }
    }
}
