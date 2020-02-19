package ua.kryha.timetrack.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebFilter(filterName = "LocaleFilter", urlPatterns = {"/*"})
public class SessionLocaleFilter implements Filter {


    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        if (request.getParameter("lang") != null) {
            request.getSession().setAttribute("lang", request.getParameter("lang"));
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}