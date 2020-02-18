package ua.kryha.timetrack.dao.implDao;

import org.apache.log4j.Logger;
import ua.kryha.timetrack.dao.PersistenseChoiceDao;
import ua.kryha.timetrack.dao.mapper.CategoryMapper;
import ua.kryha.timetrack.dao.mapper.PersistenseChoiceMapper;
import ua.kryha.timetrack.model.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ua.kryha.timetrack.dao.Queries.*;

public class PersistenseChoiceDaoJdbcImpl implements PersistenseChoiceDao {

    final static Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    private DataSource dataSource;

    public PersistenseChoiceDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PERSISTENSE_CHOICE_BY_ID)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.warn("can't delete delete persistence");
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(PersistenseChoice persistenseChoice) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PERSISTENCE_CHOICE)) {

            preparedStatement.setString(1, persistenseChoice.getAction().toString());
            preparedStatement.setInt(2, persistenseChoice.getActivity().getId());
            preparedStatement.setInt(3, persistenseChoice.getUser().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.warn("can't save Persistence");
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<PersistenseChoice> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PERSISTENCE_CHOICES)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            PersistenseChoiceMapper persistenseChoiceMapper = new PersistenseChoiceMapper();

            return persistenseChoiceMapper.extractListFromResultSet(resultSet);


        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public PersistenseChoice find(String id) {
        throw new IllegalArgumentException();
    }


    @Override
    public void update(PersistenseChoice model) {
        throw new IllegalArgumentException();
    }


}
