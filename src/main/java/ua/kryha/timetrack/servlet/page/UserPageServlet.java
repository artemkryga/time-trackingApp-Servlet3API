package ua.kryha.timetrack.servlet.page;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.request.ActivityRequest;
import ua.kryha.timetrack.payload.response.ActivityResponse;
import ua.kryha.timetrack.payload.response.UserActivityCategResponse;
import ua.kryha.timetrack.service.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/user")
public class UserPageServlet extends HttpServlet {

    private UserPageService userPageService;
    private DailyStatisticsService dailyStatisticsService;
    private PersistenceChoiсeService persistenceChoiсeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        dailyStatisticsService = (DailyStatisticsService) context.getAttribute("dailyStatisticsService");
        userPageService = (UserPageService) context.getAttribute("userPageService");
        persistenceChoiсeService = (PersistenceChoiсeService) context.getAttribute("persistenceChoiсeService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("currentUser");
        List<UserActivityCategResponse> userActivityCategResponses = userPageService.getAllActivityByUser(username);
        request.setAttribute("allActivities", userActivityCategResponses);
        request.setAttribute("StatUser", dailyStatisticsService.getUsersStatisticsByName(username));
        request.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameActivity = req.getParameter("nameActivity");
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("currentUser");
        persistenceChoiсeService.save(new ActivityRequest(nameActivity, username, action));
        resp.sendRedirect(req.getContextPath() + "/user");
    }
}

