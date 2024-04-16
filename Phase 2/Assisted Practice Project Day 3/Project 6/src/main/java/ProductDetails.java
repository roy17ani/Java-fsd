import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.EProduct; // Import EProduct class
import com.ecommerce.HibernateUtil; // Import HibernateUtil class
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet("/productDetails")
public class ProductDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get product ID from request parameter
        String productIdParam = request.getParameter("productId");

        if (productIdParam != null) {
            long productId = Long.parseLong(productIdParam);

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Retrieve product details from database using Hibernate
                EProduct product = session.get(EProduct.class, productId);

                // Display product details
                out.println("<html><body>");
                out.println("<h1>Product Details</h1>");
                out.println("<p>ID: " + product.getID() + "</p>");
                out.println("<p>Name: " + product.getName() + "</p>");
                out.println("<p>Price: " + product.getPrice() + "</p>");
                out.println("<p>Date Added: " + product.getDateAdded() + "</p>");

                // You can add more details here such as colors, sizes, etc.

                out.println("</body></html>");

                transaction.commit();
            } catch (Exception ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
                ex.printStackTrace();
            } finally {
                session.close();
            }
        } else {
            out.println("<html><body><h1>Error: Product ID is missing</h1></body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
