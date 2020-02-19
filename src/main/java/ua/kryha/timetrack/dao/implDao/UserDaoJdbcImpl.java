package ua.kryha.timetrack.dao.implDao;

import org.apache.log4j.Logger;
import ua.kryha.timetrack.dao.UserDao;
import ua.kryha.timetrack.dao.mapper.UserMapper;
import ua.kryha.timetrack.model.User;

import static ua.kryha.timetrack.dao.Queries.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoJdbcImpl implements UserDao {
    final static Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    private DataSource dataSource;

    public UserDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<User> findByUsername(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_USERNAME)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            UserMapper userMapper = new UserMapper();
            User user = userMapper.extractFromResultSet(resultSet);

            return Optional.of(user);

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(User user) {
        logger.debug("creating user: " + user.getEmail());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4 , user.getRole().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); //TODO Loger can't save user
        }
    }

    //TODO boolean
    @Override
    public Optional<User> chekByEmail(String email) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            UserMapper userMapper = new UserMapper();
            if (resultSet.next()) {
                return Optional.empty();
            }

            return Optional.of(new User("test", email, "test"));

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_EMAIL)) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            UserMapper userMapper = new UserMapper();
            User user = userMapper.extractFromResultSet(resultSet);

            return Optional.of(user);

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(User model) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            Statement statement = dataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {

                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                User user = new User(username, email);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public User find(String id) {
        return null;
    }
}
