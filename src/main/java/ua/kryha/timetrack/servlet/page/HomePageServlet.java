package ua.kryha.timetrack.servlet.page;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.DailyStatistic;
import ua.kryha.timetrack.payload.UserSessionDTO;
import ua.kryha.timetrack.payload.response.ActivityResponse;
import ua.kryha.timetrack.payload.response.DailyStatisticResponse;
import ua.kryha.timetrack.service.DailyStatisticsService;
import ua.kryha.timetrack.service.HomePageService;
import ua.kryha.timetrack.service.UserAuthService;
import ua.kryha.timetrack.service.UserPageService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

    HomePageService homePageService;

    DailyStatisticsService dailyStatisticsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();

        homePageService = (HomePageService) context.getAttribute("homePageService");
        dailyStatisticsService = (DailyStatisticsService) context.getAttribute("dailyStatisticsService");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserSessionDTO user = (UserSessionDTO) session.getAttribute("user");
        List<ActivityResponse> activitiesByUserList = homePageService.getUserActivitiesResponseByName(
                user.getUsername()
        );

        request.setAttribute("activitiesByUserList" , activitiesByUserList );
        System.out.println(user.getRole().toString());

        request.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("currentUser");
        String activityName = req.getParameter("activity");
        String time = req.getParameter("time");
        Date date = new Date(new java.util.Date().getTime());
        DailyStatisticResponse dailyStatistic = new DailyStatisticResponse(time , activityName , username);
        dailyStatisticsService.save(dailyStatistic);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
