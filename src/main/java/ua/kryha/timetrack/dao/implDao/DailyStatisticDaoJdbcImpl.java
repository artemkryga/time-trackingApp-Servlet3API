package ua.kryha.timetrack.dao.implDao;

import org.apache.log4j.Logger;
import ua.kryha.timetrack.dao.DailyStatisticDao;
import ua.kryha.timetrack.dao.mapper.DailyStatisticMapper;
import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.DailyStatistic;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import static ua.kryha.timetrack.dao.Queries.*;

public class DailyStatisticDaoJdbcImpl implements DailyStatisticDao {

    final static Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    private DataSource dataSource;

    public DailyStatisticDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<DailyStatistic> findAllByUserId(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_DAILY_STATISTICS_BY_USER_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            DailyStatisticMapper dailyStatisticMapper = new DailyStatisticMapper();

            return dailyStatisticMapper.extractListFromResultSet(resultSet);

        } catch (SQLException e) {
            logger.warn("can't find all DailyStatistic by user id");
            throw new IllegalStateException(e);
        }

    }


    @Override
    public DailyStatistic find(String id) {
        throw new IllegalArgumentException();
    }

    @Override
    public void save(DailyStatistic dailyStatistic) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_DAILY_STATISTIC)) {

            preparedStatement.setDate(1, dailyStatistic.getDate());
            preparedStatement.setString(2, dailyStatistic.getTime());
            preparedStatement.setInt(3, dailyStatistic.getUsr());
            preparedStatement.setInt(4, dailyStatistic.getActivity().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.warn("can't save dailyStat");
        }
    }

    @Override
    public void update(DailyStatistic model) {
        throw new IllegalStateException();
    }

    @Override
    public void delete(Integer id) {
        throw new IllegalStateException();
    }

    @Override
    public List<DailyStatistic> findAll() {
        throw new IllegalStateException();
    }
}
