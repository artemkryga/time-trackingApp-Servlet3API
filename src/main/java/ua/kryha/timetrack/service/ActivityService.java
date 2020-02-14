package ua.kryha.timetrack.service;

import ua.kryha.timetrack.dao.ActivityDao;
import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.payload.response.ActivityResponse;

import java.util.ArrayList;
import java.util.List;


public class ActivityService {

    private ActivityDao activityDao;

    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public Activity getActivityByName(String name){
        return activityDao.getActivityByName(name);
    }

    public List<ActivityResponse> getAllActivity(){
        List<Activity> listAct = activityDao.findAll();
        List<ActivityResponse> listActResponse = new ArrayList<>();
        for (Activity activity :
                listAct) {
            listActResponse.add(new ActivityResponse(
                    activity.getName(),activity.getCategory().getName()));
        }
        return listActResponse;
    }

}
