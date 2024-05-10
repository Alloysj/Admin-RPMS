import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if ID and password match the expected values
        if ("admin".equals(username) && "test123".equals(password)) {
           HttpSession session = request.getSession();
           session.setAttribute("username", username);
            // Redirect to home.jsp
            response.sendRedirect("index.jsp");
        } else {
            // Display an error message
            response.getWriter().println("Invalid ID or password. Please try again.");
        }
    }
}
