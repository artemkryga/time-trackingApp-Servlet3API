package ua.kryha.timetrack.servlet.auth;

import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.request.SignInRequest;
import ua.kryha.timetrack.service.UserAuthService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private UserAuthService userAuthService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userAuthService = (UserAuthService)context.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        SignInRequest signInRequest = new SignInRequest(email, password);

         User user = userAuthService.signIn(signInRequest);

         String name = user.getUsername();

        HttpSession session = request.getSession();

        session.setAttribute("currentUser" , name );
        session.setAttribute("user", email);
        response.sendRedirect("home");

    }
}