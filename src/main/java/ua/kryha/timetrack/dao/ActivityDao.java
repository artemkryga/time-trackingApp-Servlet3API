package ua.kryha.timetrack.dao;

import ua.kryha.timetrack.model.Activity;

import java.util.List;
import java.util.Set;

public interface ActivityDao extends CrudDao<Activity> {

    Activity getActivityByName(String name);

    List<Integer> getActivitiesIdByUser(String name);

    Set<Activity> activitiesByUserId(Integer id);

    void addActivityToUser(Integer userId, Integer activityId);

    void deleteActivityFromUser(Integer userId, Integer activityId);

}
