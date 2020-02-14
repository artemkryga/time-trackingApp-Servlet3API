package ua.kryha.timetrack.context;


import ua.kryha.timetrack.dao.ActivityDao;
import ua.kryha.timetrack.dao.TestDao;
import ua.kryha.timetrack.dao.implDao.ActivityDaoJdbcImpl;
import ua.kryha.timetrack.dao.implDao.TestDaoJdbcImpl;
import ua.kryha.timetrack.dao.UserDao;
import ua.kryha.timetrack.dao.implDao.UserDaoJdbcImpl;
import ua.kryha.timetrack.db.ConnectionPool;
import ua.kryha.timetrack.service.ActivityService;
import ua.kryha.timetrack.service.TestService;
import ua.kryha.timetrack.service.UserAuthService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UsersServiceListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserDao userDao = new UserDaoJdbcImpl(ConnectionPool.getInstance());
        ActivityDao activityDao = new ActivityDaoJdbcImpl(ConnectionPool.getInstance());
        ActivityService activityService = new ActivityService(activityDao);
        UserAuthService userAuthService = new UserAuthService(userDao);
        TestDao testDao = new TestDaoJdbcImpl(ConnectionPool.getInstance());
        TestService testService = new TestService(testDao);

        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("usersService", userAuthService);
        context.setAttribute("testService" , testService);
        context.setAttribute("activityService" , activityService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
