package ua.kryha.timetrack.service;

import ua.kryha.timetrack.dao.ActivityDao;
import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.payload.response.ActivityResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ActivityService {

    private ActivityDao activityDao;

    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public Activity getActivityByName(String name) {
        return activityDao.getActivityByName(name);
    }

    public Set<Activity> activitiesByUserId(Integer id) {
        return activityDao.activitiesByUserId(id);
    }

    public List<Integer> getActivitiesIdByUser(String name) {
        return activityDao.getActivitiesIdByUser(name);
    }

    public List<ActivityResponse> getAllActivity() {

        List<Activity> listAct = activityDao.findAll();

        List<ActivityResponse> listActResponse = new ArrayList<>();

        for (Activity activity : listAct) {
            listActResponse.add(new ActivityResponse(activity.getId(),
                    activity.getName(),
                    activity.getCategory().getName()));
        }

        return listActResponse;
    }

    public void addActivityToUser(Integer userId, Integer activityId) {

        activityDao.addActivityToUser(userId, activityId);

    }

    public void deleteActivityFromUser(Integer userId, Integer activityId) {

        activityDao.deleteActivityFromUser(userId, activityId);

    }


}
