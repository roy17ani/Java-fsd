import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NameServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Fetching data from HTML form
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        out.println("<html><head><title>Name Servlet Demo</title></head><body>");
        out.println("<h2>Hello, " + name + "!</h2>");
        out.println("<p>Your email address is: " + email + "</p>");
        out.println("</body></html>");
    }
}
