package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import model.User;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public SignUpServlet() {
    super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Forward to the sign-up page
    request.getRequestDispatcher("signUp.html").forward(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    int id = 0; // set a default value for the ID parameter
    
    String idParam = request.getParameter("id"); // retrieve the ID parameter value
    if (idParam != null && !idParam.isEmpty()) { // check if the ID parameter is not null or empty
        id = Integer.parseInt(idParam); // parse the ID parameter value as an integer
    }
  
    User user = new User(id, username, password, email);
    UserDAO userDao = new UserDAO();
    boolean success = userDao.addUser(user);

    String message;
    if (success) {
        message = "User registration successful!";
    } else {
        message = "User registration failed.";
    }

    request.setAttribute("message", message);
    request.getRequestDispatcher("sign-up.jsp").forward(request, response);
}
}