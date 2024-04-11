import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
public class RequestLoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Log the request
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            System.out.println("RequestLoggingFilter: " + httpRequest.getLocalAddr() + " - " + httpRequest.getRequestURI());
        }

        // Pass the request along the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Cleanup code, if needed
    }
} 

