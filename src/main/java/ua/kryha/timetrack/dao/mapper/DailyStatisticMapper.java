package ua.kryha.timetrack.dao.mapper;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.Category;
import ua.kryha.timetrack.model.DailyStatistic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class DailyStatisticMapper implements ObjectMapper<DailyStatistic> {

    @Override
    public DailyStatistic extractFromResultSet(ResultSet resultSet) throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public List<DailyStatistic> extractListFromResultSet(ResultSet resultSet) throws SQLException {

        List<DailyStatistic> dailyStatistics = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            Date date = resultSet.getDate(2);
            String time = resultSet.getString(3);
            Integer usrId = resultSet.getInt(4);
            String activityName = resultSet.getString(5);
            String categoryName = resultSet.getString(6);
            DailyStatistic dailyStatistic = new DailyStatistic(id, date, time, usrId, new Activity(activityName, new Category(categoryName)));

            dailyStatistics.add(dailyStatistic);
        }
        return dailyStatistics;
    }
}
