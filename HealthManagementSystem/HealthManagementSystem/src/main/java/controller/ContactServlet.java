package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import model.Contact;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        
        
        Contact contact = new Contact(0, name, email, message);
        ContactDAO contactDao = new ContactDAO();
        boolean isSuccess = contactDao.addContact(contact);

        if (isSuccess) {
            String thankYouMessage = "Thank you for contacting us!";
            request.setAttribute("message", thankYouMessage);
            request.getRequestDispatcher("contactUs.jsp").forward(request, response);
        } else {
            String errorMessage = "Failed to submit message. Please try again later.";
            request.setAttribute("message", errorMessage);
            request.getRequestDispatcher("contactUs.jsp").forward(request, response);
        }
    }
}
