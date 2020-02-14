package ua.kryha.timetrack.dao.mapper;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.Category;
import ua.kryha.timetrack.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityMapper implements ObjectMapper<Activity> {

    @Override
    public List<Activity> extractListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Activity> activities = new ArrayList<>();

        while (resultSet.next()) {

            String activityName = resultSet.getString(1);
            String categoryName = resultSet.getString(2);

            activities.add(new Activity(activityName, new Category(categoryName))
            );

        }
        return activities;
    }

    @Override
    public Activity extractFromResultSet(ResultSet resultSet) throws SQLException {

        return null;
    }
}
