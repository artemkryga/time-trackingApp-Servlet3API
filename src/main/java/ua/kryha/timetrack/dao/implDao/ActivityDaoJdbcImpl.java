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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static ua.kryha.timetrack.dao.Queries.*;

public class ActivityDaoJdbcImpl implements ActivityDao {

    final static Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    private DataSource dataSource;

    public ActivityDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Set<Activity> activitiesByUserId(Integer id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ACTIVITIES_BY_USER_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            ActivityMapper activityMapper = new ActivityMapper();

            return activityMapper.extractSetFromResultSet(resultSet);

        } catch (SQLException e) {
            logger.warn("can't get activities by UserId");
            throw new IllegalStateException(e);
        }

    }

    @Override
    public List<Integer> getActivitiesIdByUser(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_ACTIVITIES_ID_BY_USER)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            ActivityMapper activityMapper = new ActivityMapper();

            return activityMapper.extractListOfIntFromResultSet(resultSet);


        } catch (SQLException e) {
            logger.warn("can't get activitiesId by User");
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Activity getActivityByName(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ACTIVITY_BY_NAME)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            ActivityMapper activityMapper = new ActivityMapper();
            return activityMapper.extractFromResultSet(resultSet);

        } catch (SQLException e) {
            logger.warn("can't get activity by name");
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void addActivityToUser(Integer userId, Integer activityId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_COLUMN_INTO_USER_ACTIVITIES)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, activityId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.warn("can't save user");
            e.printStackTrace();
        }

    }

    @Override
    public void deleteActivityFromUser(Integer userId, Integer activityId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_COLUMN_FROM_USER_ACTIVITIES)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, activityId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("can't delete activity by User");
            e.printStackTrace();
        }
    }

    @Override
    public List<Activity> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_ACTIVITIES)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            ActivityMapper activityMapper = new ActivityMapper();

            return activityMapper.extractListFromResultSet(resultSet);

        } catch (SQLException e) {
            logger.warn("can't find all");
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Activity find(String id) {

        throw new IllegalArgumentException();
    }

    @Override
    public void save(Activity model) {
        throw new IllegalArgumentException();
    }

    @Override
    public void update(Activity model) {
        throw new IllegalArgumentException();
    }

    @Override
    public void delete(Integer id) {
        throw new IllegalArgumentException();
    }


}
