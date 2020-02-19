package ua.kryha.timetrack.filter;

import ua.kryha.timetrack.model.ERole;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.UserSessionDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class GlobalFilter implements Filter {

    protected ERole role;


    public GlobalFilter(ERole role) {
        this.role = role;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        UserSessionDTO userSession = (UserSessionDTO) session.getAttribute("user");

        //System.out.println(userSession.getRole().toString());
        if (userSession == null || !(userSession.getRole().toString().equals(role.toString()))) {
            servletRequest.getRequestDispatcher("/errors/error404.jsp").forward(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest , servletResponse);

    }

    @Override
    public void destroy() {

    }
}
