import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InfoPage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Info Page</h1>");
    }
}
