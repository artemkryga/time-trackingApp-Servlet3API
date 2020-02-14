package ua.kryha.timetrack.servlet.page;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.response.ActivityResponse;
import ua.kryha.timetrack.service.ActivityService;
import ua.kryha.timetrack.service.UserAuthService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/user")
public class UserPageServlet extends HttpServlet {

    private UserAuthService userAuthService;
    private ActivityService activityService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userAuthService = (UserAuthService)context.getAttribute("usersService");
        activityService = (ActivityService) context.getAttribute("activityService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ActivityResponse> activities = activityService.getAllActivity();
        request.setAttribute("activitiesFromDB", activities);
        request.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}

