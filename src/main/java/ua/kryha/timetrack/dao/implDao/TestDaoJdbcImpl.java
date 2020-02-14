package ua.kryha.timetrack.dao.implDao;

import org.apache.log4j.Logger;
import ua.kryha.timetrack.dao.TestDao;
import ua.kryha.timetrack.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ua.kryha.timetrack.dao.Queries.SQL_SELECT_ALL;

public class TestDaoJdbcImpl implements TestDao {
    final static Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    private DataSource dataSource;

    public TestDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            Statement statement = dataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {

                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                User user = new User( username, email);

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

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }
}
