package ua.kryha.timetrack.dao.mapper;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.Category;
import ua.kryha.timetrack.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActivityMapper implements ObjectMapper<Activity> {

    @Override
    public List<Activity> extractListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Activity> activities = new ArrayList<>();

        while (resultSet.next()) {

            String activityName = resultSet.getString(1);
            String categoryName = resultSet.getString(2);
            Integer activityId = resultSet.getInt(3);
            activities.add(new Activity(activityId, activityName, new Category(categoryName))
            );

        }
        return activities;
    }

    public List<Integer> extractListOfIntFromResultSet(ResultSet resultSet) throws SQLException {
        List<Integer> activitiesId = new ArrayList<>();
        while (resultSet.next()) {
            Integer activityId = resultSet.getInt(1);

            activitiesId.add(activityId);
        }
        return activitiesId;
    }


    @Override
    public Activity extractFromResultSet(ResultSet resultSet) throws SQLException {
        Activity activity = new Activity();
        while (resultSet.next()) {

            activity.setId(resultSet.getInt(1));
            activity.setName(resultSet.getString(2));
        }

        return activity;
    }

    public Set<Activity> extractSetFromResultSet(ResultSet resultSet) throws SQLException {

        Set<Activity> activities = new HashSet<>();

        while (resultSet.next()) {
            String nameActivity = resultSet.getString(1);
            String nameCategory = resultSet.getString(2);
            activities.add(new Activity(nameActivity, new Category(nameCategory)));

        }
        return activities;
    }
}
