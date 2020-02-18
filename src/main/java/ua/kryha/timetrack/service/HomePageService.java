package ua.kryha.timetrack.service;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.DailyStatistic;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.response.ActivityResponse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePageService {


    private DailyStatisticsService dailyStatisticsService;

    private ActivityService activityService;

    private UserPageService userService;

    public HomePageService(DailyStatisticsService dailyStatisticsService, ActivityService activityService, UserPageService userService) {

        this.dailyStatisticsService = dailyStatisticsService;
        this.activityService = activityService;
        this.userService = userService;

    }

    public List<ActivityResponse> getUserActivitiesResponseByName(String name) {

        User user = userService.getUserByName(name);

        Set<Activity> userActivitiesResponseSet = activityService.activitiesByUserId(user.getId());

        List<DailyStatistic> dailyStatisticsList = dailyStatisticsService.getUserStatisticsByUserId(user.getId());
        // dailyStatisticsList.stream().filter(dailyStatistics -> dailyStatistics.getDate().equals(new Date(new java.util.Date().getTime())));

        List<ActivityResponse> userActivitiesResponseList = new ArrayList<>();

        for (Activity activity : userActivitiesResponseSet) {
            userActivitiesResponseList.add(new ActivityResponse(activity.getName(),
                    activity.getCategory().getName()));
        }

        userActivitiesResponseList.forEach(userActivity ->
                dailyStatisticsList.forEach(dailyStatistics -> {
                    if (dailyStatistics.getActivity().getName().equals(userActivity.getNameAct()))
                        userActivity.setStatus("WAIT");
                }));

        return userActivitiesResponseList;
    }


}
