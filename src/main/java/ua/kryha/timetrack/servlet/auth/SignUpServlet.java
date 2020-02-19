package ua.kryha.timetrack.servlet.auth;

import ua.kryha.timetrack.exception.UserAlreadyExistException;
import ua.kryha.timetrack.exception.WrongParametersException;
import ua.kryha.timetrack.payload.request.SignUpRequest;
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

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UserAuthService userAuthService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userAuthService = (UserAuthService) context.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        SignUpRequest signUpRequest = new SignUpRequest(username, email , password);

        HttpSession session = request.getSession();

        try {

            userAuthService.signUp(signUpRequest);

            session.setAttribute("success" , "Success register");

        }catch (UserAlreadyExistException e) {

            session.setAttribute("error" , "User already exists");

            doGet(request , response);
        }
        response.sendRedirect(request.getContextPath() + "/signIn");
    }
}
