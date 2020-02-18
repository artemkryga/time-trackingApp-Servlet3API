package ua.kryha.timetrack.context;


import ua.kryha.timetrack.dao.*;
import ua.kryha.timetrack.dao.implDao.*;
import ua.kryha.timetrack.db.ConnectionPool;
import ua.kryha.timetrack.service.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UsersServiceListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionPool.getInstance());
        ActivityDao activityDao = new ActivityDaoJdbcImpl(ConnectionPool.getInstance());
        CategoryDao categoryDao = new CategoryDaoJdbcImpl(ConnectionPool.getInstance());

        ActivityService activityService = new ActivityService(activityDao);
        UserAuthService userAuthService = new UserAuthService(userDao);

        PersistenseChoiceDao persistenseChoiceDao = new PersistenseChoiceDaoJdbcImpl(ConnectionPool.getInstance());
        CategoryService categoryService = new CategoryService(categoryDao);

        DailyStatisticDao dailyStatisticDao = new DailyStatisticDaoJdbcImpl(ConnectionPool.getInstance());

        UserPageService userPageService = new UserPageService(userDao, activityService, categoryService);
        PersistenceChoiсeService persistenceChoiсeService = new PersistenceChoiсeService(persistenseChoiceDao, activityService, userPageService);
        userPageService.setPersistenceChoiceService(persistenceChoiсeService);

        DailyStatisticsService dailyStatisticsService = new DailyStatisticsService(userPageService, activityService, dailyStatisticDao);
        HomePageService homePageService = new HomePageService(dailyStatisticsService, activityService, userPageService);
        AdminPageService adminPageService = new AdminPageService(persistenceChoiсeService);

        ServletContext context = servletContextEvent.getServletContext();

        context.setAttribute("usersService", userAuthService);
        context.setAttribute("activityService", activityService);
        context.setAttribute("userPageService", userPageService);
        context.setAttribute("dailyStatisticsService", dailyStatisticsService);
        context.setAttribute("homePageService", homePageService);
        context.setAttribute("persistenceChoiсeService", persistenceChoiсeService);
        context.setAttribute("adminPageService", adminPageService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
