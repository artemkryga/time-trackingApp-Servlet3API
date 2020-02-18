package ua.kryha.timetrack.service;

import ua.kryha.timetrack.context.UsersServiceListener;
import ua.kryha.timetrack.dao.DailyStatisticDao;
import ua.kryha.timetrack.dao.UserDao;
import ua.kryha.timetrack.exception.UsernameNotFoundException;
import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.DailyStatistic;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.response.DailyStatisticResponse;
import ua.kryha.timetrack.payload.response.UserResponse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DailyStatisticsService {

    private UserPageService usersService;
    private ActivityService activityService;
    private DailyStatisticDao dailyStatisticDao;

    public DailyStatisticsService(UserPageService usersService, DailyStatisticDao dailyStatisticDao) {
        this.usersService = usersService;
        this.dailyStatisticDao = dailyStatisticDao;
    }

    public DailyStatisticsService(UserPageService usersService, ActivityService activityService, DailyStatisticDao dailyStatisticDao) {
        this.usersService = usersService;
        this.activityService = activityService;
        this.dailyStatisticDao = dailyStatisticDao;
    }

    public List<DailyStatistic> getUserStatisticsByUserId(Integer id) {

        return dailyStatisticDao.findAllByUserId(id);

    }

    public List<UserResponse> getUsersStatisticsByName(String name) {

        List<DailyStatistic> dailyStatistics = getDailyStatistics(name);
        List<UserResponse> userResponseList = new ArrayList<>();
        for (DailyStatistic daily : dailyStatistics) {
            userResponseList.add(new UserResponse(daily.getActivity().getName(),
                    daily.getTime(),
                    daily.getDate().toString()));
        }

        return userResponseList;
    }


    private List<DailyStatistic> getDailyStatistics(String name) {

        return usersService.getUserByName(name).getDailyStatistics();


    }

    public void save(DailyStatisticResponse dailyStatisticResponse) {

        DailyStatistic dailyStatistics = new DailyStatistic();

        Activity activity = activityService.getActivityByName(dailyStatisticResponse.getNameActivity());

        dailyStatistics.setActivity(activity);
        dailyStatistics.setTime(dailyStatisticResponse.getTime());
        dailyStatistics.setUsr(3);
        dailyStatistics.setDate(new Date(new java.util.Date().getTime()));

        dailyStatisticDao.save(dailyStatistics);
    }


}
