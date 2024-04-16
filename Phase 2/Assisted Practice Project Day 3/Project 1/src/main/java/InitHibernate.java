import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.HibernateUtil;

@WebServlet("/InitHibernate")
public class InitHibernate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><body>");

            SessionFactory factory = HibernateUtil.getSessionFactory();

            Session session = factory.openSession();
            out.println("Hibernate Session opened.<br>");

            // Perform database operations here...

            session.close();
            out.println("Hibernate Session closed.<br>");

            out.println("</body></html>");
        } catch (Exception ex) {
            // Log the exception
            ex.printStackTrace();
            // Send an error response to the client
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        } finally {
            // Close the PrintWriter
            if (out != null) {
                out.close();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
