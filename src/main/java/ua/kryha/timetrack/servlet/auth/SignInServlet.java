package ua.kryha.timetrack.servlet.auth;

import ua.kryha.timetrack.exception.UsernameNotFoundException;
import ua.kryha.timetrack.exception.WrongParametersException;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.UserSessionDTO;
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
        HttpSession session = request.getSession();

            try {
                User user = userAuthService.signIn(signInRequest);
                UserSessionDTO sessionUser = new UserSessionDTO(user.getUsername(),
                        user.getEmail(),
                        user.getRole());

                session.setAttribute("user" , sessionUser);

            }
            catch (WrongParametersException e) {

                session.setAttribute("error" , "Can't login");
                session.setAttribute("type", "success fade show");
                doGet(request , response);
            }

        response.sendRedirect(request.getContextPath() + "/profile");

    }
}