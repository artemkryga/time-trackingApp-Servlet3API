package ua.kryha.timetrack.dao.implDao;

import org.apache.log4j.Logger;
import ua.kryha.timetrack.dao.ActivityDao;
import ua.kryha.timetrack.dao.mapper.ActivityMapper;
import ua.kryha.timetrack.dao.mapper.CategoryMapper;
import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.Category;
import ua.kryha.timetrack.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.kryha.timetrack.dao.Queries.*;

public class ActivityDaoJdbcImpl implements ActivityDao {
    final static Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    private DataSource dataSource;

    public ActivityDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Activity getActivityByName(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ACTIVITY_BY_NAME)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            ActivityMapper activityMapper = new ActivityMapper();
            Activity activity = activityMapper.extractFromResultSet(resultSet);

            return activity;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Activity find(String id) {
        return null;
    }

    @Override
    public void save(Activity model) {

    }

    @Override
    public void update(Activity model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Activity> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_ACTIVITIES)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            ActivityMapper activityMapper = new ActivityMapper();

            List<Activity> activities = activityMapper.extractListFromResultSet(resultSet);

            return activities;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
