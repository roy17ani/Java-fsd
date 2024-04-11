import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AccountProfile extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Welcome to your profile page</h1>");
    }
}
